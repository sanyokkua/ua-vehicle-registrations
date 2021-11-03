package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.VehicleService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.VehicleEntity;
import ua.vehicle.registrations.dto.searchable.VehicleSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class VehicleController implements BaseRegistrationApi<VehicleSearchableDto, VehicleEntity, Long> {

    private final VehicleService service;

    @PostMapping(value = "/search/vehicles")
    @Override
    public Page<VehicleEntity> findRecordsByCriteria(@RequestBody VehicleSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/vehicles")
    @Override
    public long countRecordsByCriteria(@RequestBody VehicleSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/vehicles")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/vehicles/{id}")
    @Override
    public VehicleEntity findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
