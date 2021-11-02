package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.FuelService;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.jpa.FuelEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.FuelSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class FuelController implements BaseVehicleApiWithId<FuelSearchableDto, FuelEntity, String> {

    private final FuelService service;

    @PostMapping(value = "/search/fuelTypes")
    @Override
    public Page<FuelEntity> findRecordsByCriteria(@RequestBody FuelSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/fuelTypes")
    @Override
    public long countRecordsByCriteria(@RequestBody FuelSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/fuelTypes")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/fuelTypes/{id}")
    @Override
    public FuelEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
