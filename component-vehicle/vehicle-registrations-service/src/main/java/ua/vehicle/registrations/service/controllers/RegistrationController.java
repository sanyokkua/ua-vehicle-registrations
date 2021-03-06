package ua.vehicle.registrations.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.registrations.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.dto.searchable.RegistrationSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.service.services.RegistrationService;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class RegistrationController implements BaseRegistrationApi<RegistrationSearchableDto, RegistrationFlatDto,
        Long> {

    private final RegistrationService service;

    @PostMapping(value = "/search/registrations")
    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    @Override
    public Page<RegistrationFlatDto> findRecordsByCriteria(@RequestBody RegistrationSearchableDto searchObject,
            Pageable pageable
    ) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/registrations")
    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    @Override
    public long countRecordsByCriteria(@RequestBody RegistrationSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/registrations")
    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/registrations/{id}")
    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    @Override
    public RegistrationFlatDto findRecord(@PathVariable Long id) {
        return service.findRecord(id);
    }
}
