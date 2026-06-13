package co.edu.usco.convocations.server.users.domain.exceptions.business;

import co.edu.usco.convocations.server.users.domain.constants.Constants;

public class RoleWithNameNotExistsException extends RuntimeException {
    public RoleWithNameNotExistsException() {
        super(Constants.ROLE_WITH_NAME_NOT_EXISTS_MESSAGE);
    }
}
