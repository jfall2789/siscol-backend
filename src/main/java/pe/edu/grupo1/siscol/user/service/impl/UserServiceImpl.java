package pe.edu.grupo1.siscol.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.user.repository.UserRepository;
import pe.edu.grupo1.siscol.user.service.UserService;


@Service // estereoptipo service
@RequiredArgsConstructor  // para inyeccion ya no se usa autowired
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
}
