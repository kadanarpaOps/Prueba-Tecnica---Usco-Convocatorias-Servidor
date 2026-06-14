package co.edu.usco.convocations.server.users.infrastructure.output.persistence.mapper;

import co.edu.usco.convocations.server.users.domain.model.user.UserModel;
import co.edu.usco.convocations.server.users.infrastructure.output.persistence.entities.UserEntity;

public class UserPersistenceMapper {

    private RolePersistenceMapper roleMapper;

    public UserEntity toEntity(UserModel userModel) {
        return UserEntity.builder()
                .userId(userModel.getUserId())
                .uscoCode(userModel.getUscoCode())
                .userName(userModel.getUserName())
                .userEmail(userModel.getUserEmail())
                .userStatus(userModel.isUserStatus())
                .userRoles(
                        userModel.getUserRoles().stream().map(
                                roleModel -> {
                                    return roleMapper.toEntity(roleModel);
                                }
                        ).toList()
                )
                .build();
    }

    public UserModel toModel(UserEntity userEntity) {
        return UserModel.builder()
                .userId(userEntity.getUserId())
                .uscoCode(userEntity.getUscoCode())
                .userName(userEntity.getUserName())
                .userEmail(userEntity.getUserEmail())
                .userStatus(userEntity.isUserStatus())
                .userRoles(
                        userEntity.getUserRoles().stream().map(
                                roleEntity -> {
                                    return roleMapper.toModel(roleEntity);
                                }
                        ).toList()
                )
                .build();
    }

}
