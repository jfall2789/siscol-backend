package pe.edu.grupo1.siscol.user.service;

import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse register(UserRequest userRequest); // controller no debe conocer entity

    List<UserResponse> findAll();

    UserResponse finById(Long id);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);


}

