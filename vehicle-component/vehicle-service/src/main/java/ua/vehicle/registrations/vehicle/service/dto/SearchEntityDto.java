package ua.vehicle.registrations.vehicle.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ua.vehicle.registrations.vehicle.service.api.RegistrationFields;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class SearchEntityDto {

    private final String entityName;
    private final List<RegistrationFields> entityFields;

}
