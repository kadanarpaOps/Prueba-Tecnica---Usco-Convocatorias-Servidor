package co.edu.usco.convocations.server.users.domain.ports.output;

import co.edu.usco.convocations.server.common.domain.model.PaginationRequest;
import co.edu.usco.convocations.server.common.domain.model.PaginationResult;
import co.edu.usco.convocations.server.users.domain.model.user.UserFilters;
import co.edu.usco.convocations.server.users.domain.model.user.UserModel;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {

    PaginationResult<UserModel> pageUsers(PaginationRequest request, UserFilters filters);
    Optional<UserModel> findUserById(UUID userId);
    Optional<UserModel> findUserByEmail(String email);
    boolean existsByEmailOrUsername(String email, String username);
    void save(UserModel user);

}
