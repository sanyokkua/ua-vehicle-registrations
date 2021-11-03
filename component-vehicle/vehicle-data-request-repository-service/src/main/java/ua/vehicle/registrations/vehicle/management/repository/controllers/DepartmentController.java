package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.DepartmentService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.DepartmentEntity;
import ua.vehicle.registrations.dto.searchable.DepartmentSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class DepartmentController implements BaseRegistrationApi<DepartmentSearchableDto, DepartmentEntity, Long> {

    private final DepartmentService service;

    @PostMapping(value = "/search/departments")
    @Override
    public Page<DepartmentEntity> findRecordsByCriteria(@RequestBody DepartmentSearchableDto searchObject, Pageable pageable) {
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
    public DepartmentEntity findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
