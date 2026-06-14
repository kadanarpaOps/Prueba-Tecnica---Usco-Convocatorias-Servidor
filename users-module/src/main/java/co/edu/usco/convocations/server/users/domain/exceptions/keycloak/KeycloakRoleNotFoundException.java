package co.edu.usco.convocations.server.users.domain.exceptions.keycloak;

import co.edu.usco.convocations.server.users.domain.constants.Constants;

public class KeycloakRoleNotFoundException extends RuntimeException {
    public KeycloakRoleNotFoundException(String roleName) {
        super(
                String.format(Constants.ROLE_NOT_FOUND_IN_KEYCLOAK_MESSAGE, roleName)
        );
    }
}
