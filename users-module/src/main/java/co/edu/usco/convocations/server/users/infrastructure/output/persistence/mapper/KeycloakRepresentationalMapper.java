package co.edu.usco.convocations.server.users.infrastructure.output.persistence.mapper;

import co.edu.usco.convocations.server.users.domain.model.user.UserModel;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.UUID;

public class KeycloakRepresentationalMapper {

    public UserRepresentation toRepresentation(UserModel userModel) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setUsername(userModel.getUserEmail());
        userRepresentation.setEmail(userModel.getUserEmail());
        userRepresentation.setId(userModel.getUserId().toString());
        return userRepresentation;
    }

    public UserModel toModel(UserRepresentation userRepresentation) {
        return UserModel.builder()
                .userId(UUID.fromString(userRepresentation.getId()))
                .userEmail(userRepresentation.getEmail())
                .build();
    }

}
