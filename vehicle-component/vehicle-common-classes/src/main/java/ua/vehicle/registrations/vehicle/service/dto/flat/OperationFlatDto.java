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
public class OperationFlatDto {

    @FieldName(RegistrationFields.OP_CODE)
    private Long opCode;
    @FieldName(RegistrationFields.OP_NAME)
    private String opName;

}
