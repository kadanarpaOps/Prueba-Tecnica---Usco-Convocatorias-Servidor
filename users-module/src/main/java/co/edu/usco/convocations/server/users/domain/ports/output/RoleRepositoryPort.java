package co.edu.usco.convocations.server.users.domain.ports.output;

import co.edu.usco.convocations.server.common.domain.model.PageResponse;
import co.edu.usco.convocations.server.common.domain.model.PaginationRequest;
import co.edu.usco.convocations.server.users.domain.model.user.RoleModel;

import java.util.Optional;

public interface RoleRepositoryPort {

    PageResponse<RoleModel> pageRoles(PaginationRequest paginationRequest);
    Optional<RoleModel> findRoleByName(String roleName);

}
