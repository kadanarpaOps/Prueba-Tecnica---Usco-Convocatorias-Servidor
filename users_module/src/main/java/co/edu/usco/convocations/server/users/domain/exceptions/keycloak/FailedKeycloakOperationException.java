package co.edu.usco.convocations.server.users.domain.exceptions.keycloak;

import co.edu.usco.convocations.server.users.domain.constants.Constants;

public class FailedKeycloakOperationException extends RuntimeException {
    public FailedKeycloakOperationException(String operation) {
        super(
                String.format(Constants.FAILED_KEYCLOAK_OP_MESSAGE, operation)
        );
    }
}
