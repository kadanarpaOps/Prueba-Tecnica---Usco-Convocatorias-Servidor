package co.edu.usco.convocations.server.users.domain.ports.input;

import co.edu.usco.convocations.server.common.domain.model.PageResponse;
import co.edu.usco.convocations.server.common.domain.model.PaginationRequest;
import co.edu.usco.convocations.server.users.domain.model.user.UserFilters;
import co.edu.usco.convocations.server.users.domain.model.user.UserModel;

import java.util.UUID;

public interface UserUseCases {

    PageResponse<UserModel> pageUsers(PaginationRequest paginationRequest, UserFilters userFilters);
    UserModel findUserById(UUID userId);
    UserModel findUserByEmail(UUID userId);
    void registerUser(UserModel user);
    void updateUser(UserModel name, UUID userId);
    void updateUserPassword(String password, UUID userId);
    void toggleUserStatus(UserModel user);

}
