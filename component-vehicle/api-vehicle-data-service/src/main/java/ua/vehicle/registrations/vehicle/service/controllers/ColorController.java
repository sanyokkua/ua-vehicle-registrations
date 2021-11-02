package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ColorSearchableDto;
import ua.vehicle.registrations.vehicle.service.services.ColorService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class ColorController implements BaseVehicleApiWithId<ColorSearchableDto, ColorFlatDto, String> {

    private final ColorService service;

    @PostMapping(value = "/search/colors")
    @Override
    public Page<ColorFlatDto> findRecordsByCriteria(@RequestBody ColorSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/colors")
    @Override
    public long countRecordsByCriteria(@RequestBody ColorSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/colors")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/colors/{id}")
    @Override
    public ColorFlatDto findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
