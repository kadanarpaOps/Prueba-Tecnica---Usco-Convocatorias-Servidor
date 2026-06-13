package co.edu.usco.convocations.server.users.domain.exceptions.business;

import static co.edu.usco.convocations.server.users.domain.constants.Constants.USER_WITH_FIELD_NOT_EXISTS_MESSAGE;

public class UserWithFieldNotExistsException extends RuntimeException {
    public UserWithFieldNotExistsException(String fieldName) {
        super(
                String.format(USER_WITH_FIELD_NOT_EXISTS_MESSAGE, fieldName)
        );
    }
}
