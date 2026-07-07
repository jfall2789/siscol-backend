package pe.edu.grupo1.siscol.role.service;

import pe.edu.grupo1.siscol.role.dto.response.PermissionResponse;
import pe.edu.grupo1.siscol.role.entity.RolePermission;

import java.util.List;

public interface RolePermissionService {

    void assignPermission(Long roleId, Long permissionId);

    void removePermission(Long roleId, Long permissionId);

    List<PermissionResponse> getPermissionsByRole(Long roleId);

}
