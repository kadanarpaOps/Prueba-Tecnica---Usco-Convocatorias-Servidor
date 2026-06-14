package co.edu.usco.convocations.server.users.domain.exceptions.auth;

import co.edu.usco.convocations.server.users.domain.constants.Constants;

public class IncorrectCredentialsException extends RuntimeException {
    public IncorrectCredentialsException() {
        super(
                String.format(Constants.INVALID_CREDENTIALS_MESSAGE)
        );
    }
}
