package pe.edu.grupo1.siscol.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmailAndActivoTrue(String email);

    List<User> findByActivoTrue();

    Optional<User> findByIdAndActivoTrue(Long id);

}