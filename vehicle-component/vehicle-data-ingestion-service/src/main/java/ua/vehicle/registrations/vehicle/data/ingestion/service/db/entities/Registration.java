package ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Table("ua_vehicle_registrations.registration")
public class Registration {

    @Id
    @Column("reg_id")
    private Long regId;
    @Column("vehicle_id")
    private long vehicleId;
    @Column("person_type")
    private String personType;
    @Column("person_reg_address")
    private String personRegAddress;
    @Column("reg_date")
    private LocalDate regDate;
    @Column("reg_number")
    private String regNumber;
    @Column("vin_number")
    private String vinNumber;
    @Column("color_name")
    private String colorName;
    @Column("op_code")
    private long opCode;
    @Column("dep_code")
    private long depCode;
}
