package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.DepartmentFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.DepartmentSearchableDto;
import ua.vehicle.registrations.vehicle.service.services.DepartmentService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class DepartmentController implements BaseVehicleApiWithId<DepartmentSearchableDto, DepartmentFlatDto, Long> {

    private final DepartmentService service;

    @PostMapping(value = "/search/departments")
    @Override
    public Page<DepartmentFlatDto> findRecordsByCriteria(@RequestBody DepartmentSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/departments")
    @Override
    public long countRecordsByCriteria(@RequestBody DepartmentSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/departments")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/departments/{id}")
    @Override
    public DepartmentFlatDto findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
