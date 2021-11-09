package ua.vehicle.registrations.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.dto.flat.VehicleFlatDto;
import ua.vehicle.registrations.dto.searchable.VehicleSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.service.services.VehicleService;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class VehicleController implements BaseRegistrationApi<VehicleSearchableDto, VehicleFlatDto, Long> {

    private final VehicleService service;

    @PostMapping(value = "/search/vehicles")
    @Override
    public Page<VehicleFlatDto> findRecordsByCriteria(@RequestBody VehicleSearchableDto searchObject, Pageable pageable
    ) {
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
    public VehicleFlatDto findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}