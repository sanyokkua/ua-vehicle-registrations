package ua.vehicle.registrations.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum RegistrationFields {
    BODY_TYPE("bodyType", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    PERSON_TYPE("personType", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    PERSON_REG_ADDRESS("personRegAddress", List.of(CriteriaOperations.IS, CriteriaOperations.LIKE)),
    REG_DATE("regDate", List.of(CriteriaOperations.IS, CriteriaOperations.LESS_THAN, CriteriaOperations.GREATER_THAN)),
    REG_NUMBER("regNumber", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    VIN_NUMBER("vinNumber", List.of(CriteriaOperations.IS)),
    COLOR_NAME("colorName", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    BRAND_NAME("brandName", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    MODEL_NAME("modelName", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    KIND_NAME("kindName", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    FUEL_TYPE("fuelType", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    PURPOSE_NAME("purposeName", List.of(CriteriaOperations.LIKE, CriteriaOperations.IS)),
    ENGINE_CAPACITY("engineCapacity", List.of(CriteriaOperations.IS, CriteriaOperations.LESS_THAN, CriteriaOperations.GREATER_THAN)),
    MAKE_YEAR("makeYear", List.of(CriteriaOperations.IS, CriteriaOperations.LESS_THAN, CriteriaOperations.GREATER_THAN)),
    OWN_WEIGHT("ownWeight", List.of(CriteriaOperations.IS, CriteriaOperations.LESS_THAN, CriteriaOperations.GREATER_THAN)),
    TOTAL_WEIGHT("totalWeight", List.of(CriteriaOperations.IS, CriteriaOperations.LESS_THAN, CriteriaOperations.GREATER_THAN)),
    OP_CODE("opCode", List.of(CriteriaOperations.IS)),
    OP_NAME("opName", List.of(CriteriaOperations.IS, CriteriaOperations.LIKE)),
    DEP_CODE("depCode", List.of(CriteriaOperations.IS)),
    DEP_NAME("depName", List.of(CriteriaOperations.IS, CriteriaOperations.LIKE));

    private final String fieldName;
    private final List<CriteriaOperations> operations;

    RegistrationFields(String fieldName, List<CriteriaOperations> operations) {
        this.fieldName = fieldName;
        this.operations = operations;
    }
}
