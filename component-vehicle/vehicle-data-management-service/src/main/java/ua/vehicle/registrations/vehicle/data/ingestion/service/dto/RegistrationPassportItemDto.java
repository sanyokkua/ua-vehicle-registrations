package ua.vehicle.registrations.vehicle.data.ingestion.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationPassportItemDto {

    private String mimetype;
    private String profile;
    private String name;
    private String format;
    private String encoding;
    private String path;
}
