package pe.edu.grupo1.siscol.auth.service;

import pe.edu.grupo1.siscol.auth.dto.request.LoginRequest;
import pe.edu.grupo1.siscol.auth.dto.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest request);

}