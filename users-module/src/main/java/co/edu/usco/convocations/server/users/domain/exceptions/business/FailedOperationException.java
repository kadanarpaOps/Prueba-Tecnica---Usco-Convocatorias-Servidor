package co.edu.usco.convocations.server.users.domain.exceptions.business;

import co.edu.usco.convocations.server.users.domain.constants.Constants;

public class FailedOperationException extends RuntimeException {
    public FailedOperationException(String operation, String cause) {
        super(
                String.format(Constants.FAILED_OP_MESSAGE, operation, cause)
        );
    }
}
