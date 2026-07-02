package pe.edu.grupo1.siscol.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.user.entity.Permission;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    Optional<Permission> findByName(String name);// para evitar el nullPointer


}
