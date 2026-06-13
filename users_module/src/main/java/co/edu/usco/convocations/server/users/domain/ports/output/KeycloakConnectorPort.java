package co.edu.usco.convocations.server.users.domain.ports.output;

import co.edu.usco.convocations.server.users.domain.exceptions.business.UserWithFieldNotExistsException;
import co.edu.usco.convocations.server.users.domain.exceptions.keycloak.FailedKeycloakOperationException;
import co.edu.usco.convocations.server.users.domain.exceptions.keycloak.KeycloakRoleNotFoundException;
import co.edu.usco.convocations.server.users.domain.model.user.UserModel;

public interface KeycloakConnectorPort {

    String registerKeycloakUser(UserModel user) throws FailedKeycloakOperationException, UserWithFieldNotExistsException, KeycloakRoleNotFoundException;
    void updateKeycloakUser(String userId, UserModel user) throws FailedKeycloakOperationException;
    void updateKeycloakUserCredentials(String userId, String newPassword);
    UserModel findKeycloakUserByEmail(String email) throws FailedKeycloakOperationException, UserWithFieldNotExistsException;
    void toggleKeycloakUserStatus(String userId) throws FailedKeycloakOperationException;
    void rollbackKeycloakUserCreation(String userId) throws FailedKeycloakOperationException;

}
