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
public class KindSearchableDto {

    @FieldName(RegistrationFields.KIND_NAME)
    private Field<String> kindName;
}
