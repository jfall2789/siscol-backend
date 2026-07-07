package pe.edu.grupo1.siscol.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.grupo1.siscol.role.entity.RolePermission;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {


    List<RolePermission> findByRoleId(Long roleId);  //listamos los permisos de un rol

    boolean existsByRoleIdAndPermissionId(Long roleId, Long permissionId); // verificamos si un rol ya tiene un permiso

    void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId); //quitamos permiso de un rol
}
