package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.OperationFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.OperationSearchableDto;
import ua.vehicle.registrations.vehicle.service.services.OperationService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class OperationController implements BaseVehicleApiWithId<OperationSearchableDto, OperationFlatDto, Long> {

    private final OperationService service;

    @PostMapping(value = "/search/operations")
    @Override
    public Page<OperationFlatDto> findRecordsByCriteria(@RequestBody OperationSearchableDto searchObject, Pageable pageable) {
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
