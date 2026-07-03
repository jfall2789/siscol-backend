package pe.edu.grupo1.siscol.role.service;

import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;

public interface RoleService {

    RoleResponse register(RoleRequest roleRequest);

}
