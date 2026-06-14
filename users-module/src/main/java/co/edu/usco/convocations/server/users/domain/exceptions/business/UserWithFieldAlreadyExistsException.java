package co.edu.usco.convocations.server.users.domain.exceptions.business;

import static co.edu.usco.convocations.server.users.domain.constants.Constants.USER_WITH_FIELD_ALREADY_EXISTS_MESSAGE;

public class UserWithFieldAlreadyExistsException extends RuntimeException {
    public UserWithFieldAlreadyExistsException(String userType, String fieldName) {
        super(
                String.format(USER_WITH_FIELD_ALREADY_EXISTS_MESSAGE, userType, fieldName)
        );
    }
}
