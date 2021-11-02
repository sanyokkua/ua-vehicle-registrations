package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.PurposeFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.PurposeSearchableDto;
import ua.vehicle.registrations.vehicle.service.services.PurposeService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class PurposeController implements BaseVehicleApiWithId<PurposeSearchableDto, PurposeFlatDto, String> {

    private final PurposeService service;

    @PostMapping(value = "/search/purposes")
    @Override
    public Page<PurposeFlatDto> findRecordsByCriteria(@RequestBody PurposeSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/purposes")
    @Override
    public long countRecordsByCriteria(@RequestBody PurposeSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/purposes")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/purposes/{id}")
    @Override
    public PurposeFlatDto findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
