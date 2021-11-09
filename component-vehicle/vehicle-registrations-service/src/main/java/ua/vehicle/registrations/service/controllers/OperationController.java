package ua.vehicle.registrations.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.dto.searchable.OperationSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.service.services.OperationService;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class OperationController implements BaseRegistrationApi<OperationSearchableDto, OperationFlatDto, Long> {

    private final OperationService service;

    @PostMapping(value = "/search/operations")
    @Override
    public Page<OperationFlatDto> findRecordsByCriteria(@RequestBody OperationSearchableDto searchObject,
            Pageable pageable
    ) {
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
    public OperationFlatDto findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
