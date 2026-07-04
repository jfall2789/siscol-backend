package pe.edu.grupo1.siscol.role.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.grupo1.siscol.role.dto.request.RoleRequest;
import pe.edu.grupo1.siscol.role.dto.response.RoleResponse;
import pe.edu.grupo1.siscol.role.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles") //respetamos el standar con doble slash
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleResponse> register(@RequestBody RoleRequest roleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleService.register(roleRequest));


    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> findAll() {

        return ResponseEntity.ok(roleService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(roleService.findById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> update(
            @PathVariable Long id,
            @RequestBody RoleRequest roleRequest) {

        return ResponseEntity.ok(
                roleService.update(id, roleRequest)
        );

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        roleService.delete(id);

        return ResponseEntity.noContent().build();

    }


}
