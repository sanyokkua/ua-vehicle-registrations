package ua.vehicle.registrations.data.dto;

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
