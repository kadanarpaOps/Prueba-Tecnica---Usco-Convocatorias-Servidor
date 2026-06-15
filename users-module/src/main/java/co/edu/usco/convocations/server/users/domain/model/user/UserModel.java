package co.edu.usco.convocations.server.users.domain.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UserModel {

    private UUID userId;
    private String uscoCode;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<RoleModel> userRoles;
    private boolean userStatus;

}
