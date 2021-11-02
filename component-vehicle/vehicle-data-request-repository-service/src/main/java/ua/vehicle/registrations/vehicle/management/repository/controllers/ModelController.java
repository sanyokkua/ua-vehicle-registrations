package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.ModelService;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.jpa.ModelEntity;
import ua.vehicle.registrations.vehicle.service.dto.searchable.ModelSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class ModelController implements BaseVehicleApiWithId<ModelSearchableDto, ModelEntity, String> {

    private final ModelService service;

    @PostMapping(value = "/search/models")
    @Override
    public Page<ModelEntity> findRecordsByCriteria(@RequestBody ModelSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/models")
    @Override
    public long countRecordsByCriteria(@RequestBody ModelSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/models")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/models/{id}")
    @Override
    public ModelEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
