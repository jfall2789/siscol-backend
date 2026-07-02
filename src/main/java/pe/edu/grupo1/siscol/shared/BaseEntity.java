package pe.edu.grupo1.siscol.shared;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass // los atributos de esta clase seran heredados por las clases hijas
public abstract class BaseEntity //será la entidad base de las cuales todas heredan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // no persiste nulos
    private Boolean activo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    //Así siempre sabemos cuándo fue la última modificación con los sigueintes metodos:

    @PrePersist
    protected void onCreate() {
        this.activo = true;
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate //se ejecuta antes del update
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }

}