package pe.edu.grupo1.siscol.role.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.grupo1.siscol.shared.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "role_permissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "role_id",
                                "permission_id"  // aqui hacemos la restriccion de identidad
                        }
                )
        }
)
public class RolePermission extends BaseEntity { //No cargues el objeto relacionado inmediatamente; cárgalo solo cuando alguien lo solicite.

    @ManyToOne(fetch = FetchType.LAZY, optional = false)  // Un mismo rol tiene muchos registros en RolePermission.Pero cada registro de RolePermission pertenece a un solo rol.
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

}
