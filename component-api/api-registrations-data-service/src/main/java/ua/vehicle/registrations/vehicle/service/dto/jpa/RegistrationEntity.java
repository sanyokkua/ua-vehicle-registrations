package ua.vehicle.registrations.vehicle.service.dto.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationEntity {

    private Long regId;

    private String personType;

    private String personRegAddress;

    private LocalDate regDate;

    private String regNumber;

    private String vinNumber;

    private VehicleEntity vehicle;

    private ColorEntity color;

    private OperationEntity operation;

    private DepartmentEntity department;
}
