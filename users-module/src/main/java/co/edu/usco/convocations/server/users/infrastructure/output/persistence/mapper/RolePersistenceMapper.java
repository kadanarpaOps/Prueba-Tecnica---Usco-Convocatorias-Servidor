package co.edu.usco.convocations.server.users.infrastructure.output.persistence.mapper;

import co.edu.usco.convocations.server.users.domain.model.user.RoleModel;
import co.edu.usco.convocations.server.users.infrastructure.output.persistence.entities.RoleEntity;

public class RolePersistenceMapper {

    public RoleEntity toEntity(RoleModel roleModel) {
        return RoleEntity.builder()
                .roleId(roleModel.getRoleId())
                .roleName(roleModel.getRoleName())
                .build();
    }

    public RoleModel toModel(RoleEntity roleEntity) {
        return RoleModel.builder()
                .roleId(roleEntity.getRoleId())
                .roleName(roleEntity.getRoleName())
                .build();
    }

}
