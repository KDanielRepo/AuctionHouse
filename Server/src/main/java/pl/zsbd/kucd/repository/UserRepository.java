package pl.zsbd.kucd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zsbd.kucd.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    boolean existsByLogin(String login);
    Optional<User> findByLogin(String login);
    @Query("SELECT CASE WHEN COUNT(u.id) > 0 THEN 'true' ELSE 'false' END FROM User u JOIN u.userInfo ui WHERE ui.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
