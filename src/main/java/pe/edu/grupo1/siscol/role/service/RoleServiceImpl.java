package pe.edu.grupo1.siscol.role.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;


    @Override
    public RoleResponse register(RoleRequest roleRequest) {
        if(roleRepository.existsByName(roleRequest.getName())){
            throw new IllegalArgumentException("El role ya existe");
        }

        Role role = toEntity(roleRequest);
        Role savedRole = roleRepository.save(role);


        return toResponse(savedRole);
    }

    private RoleResponse toResponse(Role savedRole) {
        return modelMapper.map(savedRole, RoleResponse.class);
    }

    private Role toEntity(RoleRequest roleRequest) {

        return modelMapper.map(roleRequest, Role.class);

    }
}
