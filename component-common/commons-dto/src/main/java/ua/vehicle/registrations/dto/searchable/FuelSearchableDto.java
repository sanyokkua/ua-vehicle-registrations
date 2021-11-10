package ua.vehicle.registrations.dto.searchable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.dto.Field;
import ua.vehicle.registrations.annotations.FieldName;
import ua.vehicle.registrations.enums.RegistrationFields;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuelSearchableDto {

    @FieldName(RegistrationFields.FUEL_TYPE)
    private Field<String> fuelType;

}
