package pe.edu.grupo1.siscol.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.user.entity.User;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;
import pe.edu.grupo1.siscol.user.repository.UserRepository;
import pe.edu.grupo1.siscol.user.service.UserService;

import java.util.NoSuchElementException;


@Service // estereoptipo service en donde ira toda la logica de negocio
@RequiredArgsConstructor  // para inyeccion ya no se usa autowired
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserResponse register(UserRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }

        User user = toEntity(userRequest);
        //copia desde userequst hacia user class
        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new NoSuchElementException("El role no existe")); // usamos or Else Thronw por el optional
// new  Si llegas a estar vacío, en ese momento crea esta excepción."

        user.setRole(role); // aqui el obj user ya esta completo
        User savedUser = userRepository.save(user);
        UserResponse userResponse = toResponse(savedUser);
        userResponse.setRoleName(savedUser.getRole().getName());


        return userResponse;
    }

    //aqui contruimos los mapeadores

    private User toEntity(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class); //transforma a entidad
    }

    private UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
