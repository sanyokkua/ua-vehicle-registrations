package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.dto.flat.ModelFlatDto;
import ua.vehicle.registrations.dto.searchable.ModelSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.service.services.ModelService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class ModelController implements BaseRegistrationApi<ModelSearchableDto, ModelFlatDto, String> {

    private final ModelService service;

    @PostMapping(value = "/search/models")
    @Override
    public Page<ModelFlatDto> findRecordsByCriteria(@RequestBody ModelSearchableDto searchObject, Pageable pageable) {
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
    public ModelFlatDto findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
