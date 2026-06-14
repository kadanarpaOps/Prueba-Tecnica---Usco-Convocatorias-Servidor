package co.edu.usco.convocations.server.users.infrastructure.output.persistence.repository;

import co.edu.usco.convocations.server.users.infrastructure.output.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, UUID> {

}
