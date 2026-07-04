package pe.edu.grupo1.siscol.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;
import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;
import pe.edu.grupo1.siscol.user.entity.User;
import pe.edu.grupo1.siscol.user.repository.UserRepository;
import pe.edu.grupo1.siscol.user.service.UserService;

import java.util.List;
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

        System.out.println("User ID: " + user.getId());

        if (user.getRole() != null) {
            System.out.println("Role ID: " + user.getRole().getId());
        }

        User savedUser = userRepository.save(user);
        UserResponse userResponse = toResponse(savedUser);
        userResponse.setRoleName(savedUser.getRole().getName());


        return userResponse;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public UserResponse finById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("El usuario no existe"));
        return toResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("El usuario no existe"));

        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new NoSuchElementException("El rol no existe"));

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPosition(userRequest.getPosition());
        user.setRole(role);

        User updatedUser = userRepository.save(user);

        UserResponse userResponse = toResponse(updatedUser);
        userResponse.setRoleName(updatedUser.getRole().getName());

        return userResponse;
    }

    @Override
    public void delete(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("El usuario no existe"));

        user.setActivo(false);

        userRepository.save(user);

    }


    //aqui contruimos los mapeadores

    private User toEntity(UserRequest userRequest) {

        User user = new User();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPosition(userRequest.getPosition());

        return user;
    }

    private UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }
}
