package pe.edu.grupo1.siscol.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);// PARA evitar nullPointer

    boolean existsByEmail(String email);


}
