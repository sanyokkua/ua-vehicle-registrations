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
public class BrandFlatDto {

    @FieldName(RegistrationFields.BRAND_NAME)
    private String brandName;

}
