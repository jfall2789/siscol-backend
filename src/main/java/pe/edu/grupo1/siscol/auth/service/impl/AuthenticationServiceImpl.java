package pe.edu.grupo1.siscol.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pe.edu.grupo1.siscol.auth.dto.request.LoginRequest;
import pe.edu.grupo1.siscol.auth.dto.response.LoginResponse;
import pe.edu.grupo1.siscol.auth.security.CustomUserDetailsService;
import pe.edu.grupo1.siscol.auth.security.JwtService;
import pe.edu.grupo1.siscol.auth.service.AuthenticationService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService userDetailsService;

    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(

                        request.getEmail(),

                        request.getPassword()

                )

        );

        UserDetails user = userDetailsService.loadUserByUsername(
                request.getEmail());

        String token = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .type("Bearer")
                .build();

    }

}