package pl.zsbd.kucd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zsbd.kucd.entity.Role;
import pl.zsbd.kucd.enums.Roles;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoles(Roles roles);
    @Query("SELECT r.id FROM Role r WHERE r.roles = :roles")
    Long findIdByRoles(@Param("roles") Roles roles);
}
