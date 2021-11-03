package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.OperationService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.OperationEntity;
import ua.vehicle.registrations.dto.searchable.OperationSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class OperationController implements BaseRegistrationApi<OperationSearchableDto, OperationEntity, Long> {

    private final OperationService service;

    @PostMapping(value = "/search/operations")
    @Override
    public Page<OperationEntity> findRecordsByCriteria(@RequestBody OperationSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/operations")
    @Override
    public long countRecordsByCriteria(@RequestBody OperationSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/operations")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/operations/{id}")
    @Override
    public OperationEntity findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
