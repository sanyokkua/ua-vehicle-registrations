package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.RegistrationService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.RegistrationEntity;
import ua.vehicle.registrations.dto.searchable.RegistrationSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class RegistrationController implements BaseRegistrationApi<RegistrationSearchableDto, RegistrationEntity, Long> {

    private final RegistrationService service;

    @PostMapping(value = "/search/registrations")
    @Override
    public Page<RegistrationEntity> findRecordsByCriteria(@RequestBody RegistrationSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/registrations")
    @Override
    public long countRecordsByCriteria(@RequestBody RegistrationSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/registrations")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/registrations/{id}")
    @Override
    public RegistrationEntity findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
