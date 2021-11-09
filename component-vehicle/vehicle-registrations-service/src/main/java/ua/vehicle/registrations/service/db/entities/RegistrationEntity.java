package ua.vehicle.registrations.service.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @Column(name = "reg_id")
    private Long regId;
    @Column(name = "person_type")
    private String personType;
    @Column(name = "person_reg_address")
    private String personRegAddress;
    @Column(name = "reg_date")
    private LocalDate regDate;
    @Column(name = "reg_number")
    private String regNumber;
    @Column(name = "vin_number")
    private String vinNumber;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;
    @ManyToOne
    @JoinColumn(name = "color_name", nullable = false)
    private ColorEntity color;
    @ManyToOne
    @JoinColumn(name = "op_code", nullable = false)
    private OperationEntity operation;
    @ManyToOne
    @JoinColumn(name = "dep_code", nullable = false)
    private DepartmentEntity department;
}
