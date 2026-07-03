package pe.edu.grupo1.siscol.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;
import pe.edu.grupo1.siscol.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController { //aqui expondremos los endpoints de Users

    private final UserService userService;


    @PostMapping //responde la peticion hhttp post
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(userRequest));
        // Por ahora devolverá un 201 created como tiene que ser
    }


}
