package pe.edu.grupo1.siscol.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.user.entity.User;
import pe.edu.grupo1.siscol.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmailAndActivoTrue(email)

                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "Usuario no encontrado."
                        ));

        return new CustomUserDetails(user);

    }

}