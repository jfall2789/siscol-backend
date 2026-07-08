package pe.edu.grupo1.siscol.role.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.grupo1.siscol.exception.permission.PermissionNotFoundException;
import pe.edu.grupo1.siscol.exception.role.RoleNotFoundException;
import pe.edu.grupo1.siscol.role.dto.response.PermissionResponse;
import pe.edu.grupo1.siscol.role.entity.Permission;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.entity.RolePermission;
import pe.edu.grupo1.siscol.role.repository.PermissionRepository;
import pe.edu.grupo1.siscol.role.repository.RolePermissionRepository;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;
import pe.edu.grupo1.siscol.role.service.RolePermissionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    private final RolePermissionRepository rolePermissionRepository;

    private final ModelMapper modelMapper;

    @Override
    public void assignPermission(Long roleId, Long permissionId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException(roleId));

        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new PermissionNotFoundException(permissionId));

        if (rolePermissionRepository.existsByRoleIdAndPermissionId(roleId, permissionId)) {
            throw new IllegalArgumentException("El permiso ya está asignado al rol.");
        }

        RolePermission rolePermission = new RolePermission();

        rolePermission.setRole(role);
        rolePermission.setPermission(permission);

        rolePermissionRepository.save(rolePermission);
    }

    @Override
    @Transactional
    public void removePermission(Long roleId, Long permissionId) {

        if (!rolePermissionRepository.existsByRoleIdAndPermissionId(roleId, permissionId)) {
            throw new IllegalArgumentException("El permiso no está asignado al rol.");
        }

        rolePermissionRepository.deleteByRoleIdAndPermissionId(roleId, permissionId);
    }

    @Override
    public List<PermissionResponse> getPermissionsByRole(Long roleId) {

        return rolePermissionRepository.findByRoleId(roleId)
                .stream()
                .map(RolePermission::getPermission)
                .map(permission -> modelMapper.map(permission, PermissionResponse.class))
                .toList();
    }

}