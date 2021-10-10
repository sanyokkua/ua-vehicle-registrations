package ua.vehicle.registrations.vehicle.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Vehicle {

    private Long vehicleId;
    private String brandName;
    private String modelName;
    private String bodyType;
    private String kindName;
    private String fuelType;
    private String purposeName;
    private int engineCapacity;
    private int makeYear;
    private int ownWeight;
    private int totalWeight;
}
