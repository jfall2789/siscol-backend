package pe.edu.grupo1.siscol.role.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.exception.role.RoleNotFoundException;
import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;
import pe.edu.grupo1.siscol.role.service.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoleResponse register(RoleRequest roleRequest) {

        if (roleRepository.existsByName(roleRequest.getName())) {
            throw new IllegalArgumentException("El rol ya existe");
        }

        Role role = toEntity(roleRequest);

        Role savedRole = roleRepository.save(role);

        return toResponse(savedRole);
    }

    @Override
    public List<RoleResponse> findAll() {

        return roleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public RoleResponse findById(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        return toResponse(role);
    }

    @Override
    public RoleResponse update(Long id, RoleRequest roleRequest) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());

        Role updatedRole = roleRepository.save(role);

        return toResponse(updatedRole);
    }

    @Override
    public void delete(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));

        role.setActivo(false);

        roleRepository.save(role);
    }

    /**
     * Convierte Role a RoleResponse
     */
    private RoleResponse toResponse(Role role) {
        return modelMapper.map(role, RoleResponse.class);
    }

    /**
     * Convierte RoleRequest a Role
     */
    private Role toEntity(RoleRequest roleRequest) {
        return modelMapper.map(roleRequest, Role.class);
    }

}