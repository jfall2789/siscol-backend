package pe.edu.grupo1.siscol.role.service;

import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse register(RoleRequest roleRequest);

    List<RoleResponse> findAll();

    RoleResponse findById(Long id);

    RoleResponse update(Long id, RoleRequest roleRequest);

    void delete(Long id);

}
