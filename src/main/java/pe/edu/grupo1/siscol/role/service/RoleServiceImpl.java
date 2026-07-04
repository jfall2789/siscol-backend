package pe.edu.grupo1.siscol.role.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;


    @Override
    public RoleResponse register(RoleRequest roleRequest) {
        if (roleRepository.existsByName(roleRequest.getName())) {
            throw new IllegalArgumentException("El role ya existe");
        }

        Role role = toEntity(roleRequest);
        Role savedRole = roleRepository.save(role);


        return toResponse(savedRole);
    }

    @Override
    public List<RoleResponse> findAll() {

        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(this::toResponse)
                .toList();

    }

    @Override
    public RoleResponse findById(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("El rol no existe"));

        return toResponse(role);

    }

    @Override
    public RoleResponse update(Long id, RoleRequest roleRequest) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("El rol no existe"));

        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());

        Role updatedRole = roleRepository.save(role);

        return toResponse(updatedRole);

    }

    @Override
    public void delete(Long id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("El rol no existe"));

        role.setActivo(false);

        roleRepository.save(role);

    }


    //metodos auxiliares para mapear con modelMapper

    private RoleResponse toResponse(Role savedRole) {
        return modelMapper.map(savedRole, RoleResponse.class);
    }

    private Role toEntity(RoleRequest roleRequest) {

        return modelMapper.map(roleRequest, Role.class);

    }
}
