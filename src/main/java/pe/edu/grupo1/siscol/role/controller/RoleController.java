package pe.edu.grupo1.siscol.role.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;
import pe.edu.grupo1.siscol.role.service.RoleService;

@RestController
@RequestMapping("/api/roles") //respetamos el standar con doble slash
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponse> register(@RequestBody RoleRequest roleRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleService.register(roleRequest));


    }

}
