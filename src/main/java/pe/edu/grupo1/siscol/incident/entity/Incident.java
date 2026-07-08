package pe.edu.grupo1.siscol.incident.entity;


import jakarta.persistence.*;
import lombok.*;
import pe.edu.grupo1.siscol.incident.enums.IncidentPriority;
import pe.edu.grupo1.siscol.incident.enums.IncidentStatus;
import pe.edu.grupo1.siscol.incident.enums.IncidentType;
import pe.edu.grupo1.siscol.incident.enums.IncidentUrgency;
import pe.edu.grupo1.siscol.shared.BaseEntity;
import pe.edu.grupo1.siscol.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident extends BaseEntity {

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 100)
    private String location;
    //  Aquí agregamos los enums

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentUrgency urgency;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentPriority priority;

    //REPORTES

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_support_id") // null false porque cuando se crea aun nadie la toma
    private User assignedSupport;

    //DATE

    @Column(name = "assignment_date")
    private LocalDateTime assignmentDate;

    @Column(name = "closed_date")
    private LocalDateTime closedDate;


}
