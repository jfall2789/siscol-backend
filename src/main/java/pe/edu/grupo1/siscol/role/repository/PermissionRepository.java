package pe.edu.grupo1.siscol.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.role.entity.Permission;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findByCode(String code);

    boolean existsByCode(String code);

}
