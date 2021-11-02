package ua.vehicle.registrations.vehicle.data.ingestion.service.dto;

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
