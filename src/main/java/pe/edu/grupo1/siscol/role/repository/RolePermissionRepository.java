package pe.edu.grupo1.siscol.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.role.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    //solo necesitamos crud no necesitamos algo mas de momento
}
