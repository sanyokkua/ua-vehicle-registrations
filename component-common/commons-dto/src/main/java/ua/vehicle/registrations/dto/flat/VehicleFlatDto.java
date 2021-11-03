package ua.vehicle.registrations.dto.flat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.annotations.FieldName;
import ua.vehicle.registrations.enums.RegistrationFields;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFlatDto {

    private Long vehicleId;
    @FieldName(RegistrationFields.BRAND_NAME)
    private String brandName;
    @FieldName(RegistrationFields.MODEL_NAME)
    private String modelName;
    @FieldName(RegistrationFields.BODY_TYPE)
    private String bodyType;
    @FieldName(RegistrationFields.KIND_NAME)
    private String kindName;
    @FieldName(RegistrationFields.FUEL_TYPE)
    private String fuelType;
    @FieldName(RegistrationFields.PURPOSE_NAME)
    private String purposeName;
    @FieldName(RegistrationFields.ENGINE_CAPACITY)
    private long engineCapacity;
    @FieldName(RegistrationFields.MAKE_YEAR)
    private long makeYear;
    @FieldName(RegistrationFields.OWN_WEIGHT)
    private long ownWeight;
    @FieldName(RegistrationFields.TOTAL_WEIGHT)
    private long totalWeight;

}
