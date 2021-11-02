package ua.vehicle.registrations.vehicle.service.dto.flat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.vehicle.service.api.FieldName;
import ua.vehicle.registrations.vehicle.service.api.RegistrationFields;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuelFlatDto {

    @FieldName(RegistrationFields.FUEL_TYPE)
    private String fuelType;

}
