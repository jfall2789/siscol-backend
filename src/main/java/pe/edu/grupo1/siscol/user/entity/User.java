package pe.edu.grupo1.siscol.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.grupo1.siscol.role.entity.Role;
import pe.edu.grupo1.siscol.shared.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, unique = true, length = 150)
    // Un correo institucional solo puede pertenecer a un usuario.
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 80)
    private String position;  // director docente secretaria etc

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    //¿Cuántos usuarios pueden tener el rol Administrador?
    //
    //Muchos.
}
