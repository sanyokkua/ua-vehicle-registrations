package ua.vehicle.registrations.vehicle.service.dto.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class VehicleEntity {

    private Long vehicleId;

    private int engineCapacity;

    private int makeYear;

    private int ownWeight;

    private int totalWeight;

    private BrandEntity brand;

    private ModelEntity model;

    private BodyEntity body;

    private KindEntity kind;

    private FuelEntity fuel;

    private PurposeEntity purpose;

}
