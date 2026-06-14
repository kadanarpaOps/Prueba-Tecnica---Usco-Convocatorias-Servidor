package co.edu.usco.convocations.server.users.domain.constants;

public class Constants {

    private Constants() {}

    // Messages
    public static final String USER_WITH_FIELD_ALREADY_EXISTS_MESSAGE = "User with that %s already exists";
    public static final String USER_WITH_FIELD_NOT_EXISTS_MESSAGE = "User with that %s does not exists";
    public static final String ROLE_WITH_NAME_NOT_EXISTS_MESSAGE = "Role %s does not exist";
    public static final String FAILED_KEYCLOAK_OP_MESSAGE = "Failed %s due Errors in the Network Connection";
    public static final String ROLE_NOT_FOUND_IN_KEYCLOAK_MESSAGE = "Role %s does not exist in Authentication Server";
    public static final String INVALID_CREDENTIALS_MESSAGE = "Invalid Email or Password";

    public static final String USER_INVALID_USCO_CODE_MESSAGE = "Invalid USCO code";
    public static final String USER_INVALID_EMAIL_MESSAGE = "Invalid email";
    public static final String USER_INVALID_NAME_MESSAGE = "Invalid name";
    public static final String USER_INVALID_PASSWORD_MESSAGE = "Invalid password";

    // Operations
    public static final String CREATION_OP = "Creation";

    // Fields
    public static final String ID = "id";
    public static final String USCO_CODE = "usco code";
    public static final String EMAIL = "email";

}
