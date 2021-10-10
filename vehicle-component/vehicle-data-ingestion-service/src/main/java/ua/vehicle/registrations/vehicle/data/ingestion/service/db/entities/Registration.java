package ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

    private Long regId;
    private long vehicleId;
    private String personType;
    private String personRegAddress;
    private LocalDate regDate;
    private String regNumber;
    private String vinNumber;
    private String colorName;
    private long opCode;
    private long depCode;
}
