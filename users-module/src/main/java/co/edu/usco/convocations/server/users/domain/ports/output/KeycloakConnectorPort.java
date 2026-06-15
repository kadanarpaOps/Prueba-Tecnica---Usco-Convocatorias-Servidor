package co.edu.usco.convocations.server.users.domain.ports.output;

import co.edu.usco.convocations.server.users.domain.exceptions.business.UserWithFieldNotExistsException;
import co.edu.usco.convocations.server.users.domain.exceptions.business.FailedOperationException;
import co.edu.usco.convocations.server.users.domain.exceptions.keycloak.KeycloakRoleNotFoundException;
import co.edu.usco.convocations.server.users.domain.model.user.UserModel;

public interface KeycloakConnectorPort {

    String registerKeycloakUser(UserModel user) throws FailedOperationException, UserWithFieldNotExistsException, KeycloakRoleNotFoundException;
    void updateKeycloakUser(String userId, UserModel user) throws FailedOperationException;
    void updateKeycloakUserCredentials(String userId, String newPassword);
    UserModel findKeycloakUserByEmail(String email) throws FailedOperationException, UserWithFieldNotExistsException;
    void toggleKeycloakUserStatus(String userId) throws FailedOperationException;
    void rollbackKeycloakUserCreation(String userId) throws FailedOperationException;

}
