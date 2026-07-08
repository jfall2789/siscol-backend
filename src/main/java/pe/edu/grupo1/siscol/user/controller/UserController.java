package pe.edu.grupo1.siscol.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo1.siscol.user.dto.request.UserRequest;
import pe.edu.grupo1.siscol.user.dto.response.UserResponse;
import pe.edu.grupo1.siscol.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(
        name = "Usuarios",
        description = "Operaciones para la gestión de usuarios del sistema."
)
public class UserController { //aqui expondremos los endpoints de Users

    private final UserService userService;


    @PostMapping //responde la peticion hhttp post
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(userRequest));
        // Por ahora devolverá un 201 created como tiene que ser
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.finById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(userService.update(id, userRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return ResponseEntity.noContent().build();

    }


}
