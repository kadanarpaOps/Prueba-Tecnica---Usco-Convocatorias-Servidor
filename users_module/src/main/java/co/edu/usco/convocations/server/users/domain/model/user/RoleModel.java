package co.edu.usco.convocations.server.users.domain.model.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class RoleModel {

    private UUID roleId;
    private String roleName;

}
