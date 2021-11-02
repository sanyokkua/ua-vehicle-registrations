package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.ColorService;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ColorEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ColorSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class ColorController implements BaseVehicleApiWithId<ColorSearchableDto, ColorEntity, String> {

    private final ColorService service;

    @PostMapping(value = "/search/colors")
    @Override
    public Page<ColorEntity> findRecordsByCriteria(@RequestBody ColorSearchableDto searchObject, Pageable pageable) {
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
    public ColorEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
