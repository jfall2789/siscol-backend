package pe.edu.grupo1.siscol.user.service;

import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;

public interface UserService {

    UserResponse register(UserRequest userRequest); // controller no debe conocer entity

}

