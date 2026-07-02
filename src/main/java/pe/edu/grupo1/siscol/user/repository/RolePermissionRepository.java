package pe.edu.grupo1.siscol.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.user.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    //solo necesitamos crud no necesitamos algo mas de momento
}
