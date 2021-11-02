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
public class DepartmentFlatDto {

    @FieldName(RegistrationFields.DEP_CODE)
    private Long depCode;
    @FieldName(RegistrationFields.DEP_NAME)
    private String depName;

}
