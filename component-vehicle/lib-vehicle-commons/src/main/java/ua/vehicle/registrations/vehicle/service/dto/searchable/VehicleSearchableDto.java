package ua.vehicle.registrations.vehicle.service.dto.searchable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.vehicle.service.api.Field;
import ua.vehicle.registrations.vehicle.service.api.FieldName;
import ua.vehicle.registrations.vehicle.service.api.RegistrationFields;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSearchableDto {

    private Field<Long> vehicleId;
    @FieldName(RegistrationFields.BRAND_NAME)
    private Field<String> brandName;
    @FieldName(RegistrationFields.MODEL_NAME)
    private Field<String> modelName;
    @FieldName(RegistrationFields.BODY_TYPE)
    private Field<String> bodyType;
    @FieldName(RegistrationFields.KIND_NAME)
    private Field<String> kindName;
    @FieldName(RegistrationFields.FUEL_TYPE)
    private Field<String> fuelType;
    @FieldName(RegistrationFields.PURPOSE_NAME)
    private Field<String> purposeName;
    @FieldName(RegistrationFields.ENGINE_CAPACITY)
    private Field<Long> engineCapacity;
    @FieldName(RegistrationFields.MAKE_YEAR)
    private Field<Long> makeYear;
    @FieldName(RegistrationFields.OWN_WEIGHT)
    private Field<Long> ownWeight;
    @FieldName(RegistrationFields.TOTAL_WEIGHT)
    private Field<Long> totalWeight;
}
