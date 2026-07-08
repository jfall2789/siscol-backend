package pe.edu.grupo1.siscol.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.exception.role.RoleNotFoundException;
import pe.edu.grupo1.siscol.exception.user.UserNotFoundException;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.role.repository.RoleRepository;
import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;
import pe.edu.grupo1.siscol.user.entity.User;
import pe.edu.grupo1.siscol.user.repository.UserRepository;
import pe.edu.grupo1.siscol.user.service.UserService;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;



    @Override
    public UserResponse register(UserRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new IllegalArgumentException("El email ya se encuentra registrado");
        }

        User user = toEntity(userRequest);

        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new RoleNotFoundException(userRequest.getRoleId()));

        user.setRole(role);

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
                .orElseThrow(() -> new UserNotFoundException(id));

        return toResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        Role role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new RoleNotFoundException(userRequest.getRoleId()));

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(
                passwordEncoder.encode(userRequest.getPassword())
        );
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
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setActivo(false);

        userRepository.save(user);
    }

    /**
     * Convierte UserRequest a User
     */
    private User toEntity(UserRequest userRequest) {

        User user = new User();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(
                passwordEncoder.encode(userRequest.getPassword())
        );
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setPosition(userRequest.getPosition());

        return user;
    }

    /**
     * Convierte User a UserResponse
     */
    private UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

}