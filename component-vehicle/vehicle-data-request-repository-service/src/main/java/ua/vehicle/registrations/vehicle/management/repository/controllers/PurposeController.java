package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.PurposeService;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.jpa.PurposeEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.PurposeSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class PurposeController implements BaseVehicleApiWithId<PurposeSearchableDto, PurposeEntity, String> {

    private final PurposeService service;

    @PostMapping(value = "/search/purposes")
    @Override
    public Page<PurposeEntity> findRecordsByCriteria(@RequestBody PurposeSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/purposes")
    @Override
    public long countRecordsByCriteria(@RequestBody PurposeSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/purposes")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/purposes/{id}")
    @Override
    public PurposeEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
