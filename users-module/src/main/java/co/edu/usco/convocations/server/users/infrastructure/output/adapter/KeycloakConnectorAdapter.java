package co.edu.usco.convocations.server.users.infrastructure.output.adapter;

import static co.edu.usco.convocations.server.users.domain.constants.Constants.CREATION_OP;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.KEYCLOAK_ERR_CONNECTION;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.ROLE_IS_REQUIRED;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.SEARCH_OP;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.FIELD_WITH_VALUE_NOT_EXIST;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.ID;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.UPDATE_OP;
import static co.edu.usco.convocations.server.users.domain.constants.Constants.DELETION_OP;

import co.edu.usco.convocations.server.users.domain.exceptions.business.FailedOperationException;
import co.edu.usco.convocations.server.users.domain.exceptions.business.UserWithFieldNotExistsException;
import co.edu.usco.convocations.server.users.domain.exceptions.keycloak.KeycloakRoleNotFoundException;
import co.edu.usco.convocations.server.users.domain.model.user.RoleModel;
import co.edu.usco.convocations.server.users.domain.model.user.UserModel;
import co.edu.usco.convocations.server.users.domain.ports.output.KeycloakConnectorPort;
import co.edu.usco.convocations.server.users.infrastructure.output.persistence.mapper.KeycloakRepresentationalMapper;
import co.edu.usco.convocations.server.users.infrastructure.output.persistence.repository.KeycloakUserRepository;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class KeycloakConnectorAdapter implements KeycloakConnectorPort {

    private final KeycloakUserRepository keycloakRepository;
    private final KeycloakRepresentationalMapper keycloakMapper;

    @Override
    public String registerKeycloakUser(UserModel user) throws FailedOperationException, UserWithFieldNotExistsException, KeycloakRoleNotFoundException {
        String userId;
        UserRepresentation keycloakUser = keycloakMapper.toRepresentation(user);
        List<RoleModel> rolesToAdd = user.getUserRoles();

        assignCredentials(keycloakUser, user.getUserPassword());

        if (rolesToAdd.isEmpty()) {
            throw new FailedOperationException(CREATION_OP, ROLE_IS_REQUIRED);
        }

        rolesToAdd.forEach(roleModel -> {
            try {
                keycloakUser.getRealmRoles().add(
                        keycloakRepository.getRoleByName(roleModel.getRoleName()).getName()
                );
            } catch (RuntimeException e) {
                throw new KeycloakRoleNotFoundException(roleModel.getRoleName());
            }
        });

        try {
            userId = keycloakRepository.save(keycloakUser);
        } catch (RuntimeException e) {
            throw new FailedOperationException(CREATION_OP, KEYCLOAK_ERR_CONNECTION);
        }

        return userId;
    }

    @Override
    public void updateKeycloakUser(String userId, UserModel user) throws FailedOperationException {
        try {
            keycloakRepository.getById(userId);
        } catch (RuntimeException e) {
            throw new FailedOperationException(SEARCH_OP, String.format(FIELD_WITH_VALUE_NOT_EXIST, ID, userId));
        }
        try {
            keycloakRepository.update(userId, keycloakMapper.toRepresentation(user));
        } catch (RuntimeException e) {
            throw new FailedOperationException(UPDATE_OP, KEYCLOAK_ERR_CONNECTION);
        }
    }

    @Override
    public void updateKeycloakUserCredentials(String userId, String newPassword) {
        UserRepresentation userFromKeycloak = this.findUserFromKeycloakById(userId);
        assignCredentials(userFromKeycloak, newPassword);
        try {
            keycloakRepository.update(userId, userFromKeycloak);
        } catch (RuntimeException e) {
            throw new FailedOperationException(UPDATE_OP, KEYCLOAK_ERR_CONNECTION);
        }
    }

    @Override
    public UserModel findKeycloakUserByEmail(String email) throws FailedOperationException, UserWithFieldNotExistsException {
        UserRepresentation userFromKeycloak = keycloakRepository.getByEmail(email);
        if (userFromKeycloak == null) {
            return null;
        }
        return keycloakMapper.toModel(userFromKeycloak);
    }

    @Override
    public void toggleKeycloakUserStatus(String userId) throws FailedOperationException {
        try {
            UserRepresentation userToKeycloak = keycloakRepository.getById(userId);
            userToKeycloak.setEnabled(!userToKeycloak.isEnabled());
            keycloakRepository.update(userId, userToKeycloak);
        } catch(RuntimeException e) {
            throw new FailedOperationException(UPDATE_OP, KEYCLOAK_ERR_CONNECTION);
        }
    }

    @Override
    public void rollbackKeycloakUserCreation(String userId) throws FailedOperationException {
        try {
            keycloakRepository.delete(userId);
        } catch (RuntimeException e) {
            throw new FailedOperationException(DELETION_OP, KEYCLOAK_ERR_CONNECTION);
        }
    }

    private UserRepresentation findUserFromKeycloakById(String userId) {
        UserRepresentation userFromKeycloak = keycloakRepository.getById(userId);
        if (userFromKeycloak == null) {
            throw new FailedOperationException(SEARCH_OP, String.format(FIELD_WITH_VALUE_NOT_EXIST, ID, userId));
        }
        return userFromKeycloak;
    }

    private void assignCredentials(UserRepresentation user, String password) {
        user.setCredentials(Collections.emptyList());

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);
        credential.setTemporary(false);

        user.setCredentials(Collections.singletonList(credential));
    }

}
