package ua.vehicle.registrations.dto.flat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.vehicle.registrations.annotations.FieldName;
import ua.vehicle.registrations.enums.RegistrationFields;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFlatDto {

    private Long regId;
    @FieldName(RegistrationFields.PERSON_TYPE)
    private String personType;
    @FieldName(RegistrationFields.PERSON_REG_ADDRESS)
    private String personRegAddress;
    @FieldName(RegistrationFields.REG_DATE)
    private LocalDate regDate;
    @FieldName(RegistrationFields.REG_NUMBER)
    private String regNumber;
    @FieldName(RegistrationFields.VIN_NUMBER)
    private String vinNumber;
    @FieldName(RegistrationFields.COLOR_NAME)
    private String colorName;

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
    @FieldName(RegistrationFields.OP_CODE)
    private Long opCode;
    @FieldName(RegistrationFields.OP_NAME)
    private String opName;
    @FieldName(RegistrationFields.DEP_CODE)
    private Long depCode;
    @FieldName(RegistrationFields.DEP_NAME)
    private String depName;

}
