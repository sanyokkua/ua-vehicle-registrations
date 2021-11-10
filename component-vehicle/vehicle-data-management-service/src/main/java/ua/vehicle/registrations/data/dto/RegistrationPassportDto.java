package ua.vehicle.registrations.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationPassportDto {

    private List<RegistrationPassportItemDto> resources;
}
