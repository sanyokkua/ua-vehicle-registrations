package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.BodyService;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.jpa.BodyEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.BodySearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class BodyController implements BaseVehicleApiWithId<BodySearchableDto, BodyEntity, String> {

    private final BodyService service;

    @PostMapping(value = "/search/bodies")
    @Override
    public Page<BodyEntity> findRecordsByCriteria(@RequestBody BodySearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping("/count/bodies")
    @Override
    public long countRecordsByCriteria(@RequestBody BodySearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/bodies")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/bodies/{id}")
    @Override
    public BodyEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
