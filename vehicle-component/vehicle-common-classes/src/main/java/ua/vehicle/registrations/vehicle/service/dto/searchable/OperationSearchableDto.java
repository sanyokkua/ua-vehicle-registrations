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
public class OperationSearchableDto {

    @FieldName(RegistrationFields.OP_CODE)
    private Field<Long> opCode;
    @FieldName(RegistrationFields.OP_NAME)
    private Field<String> opName;
}
