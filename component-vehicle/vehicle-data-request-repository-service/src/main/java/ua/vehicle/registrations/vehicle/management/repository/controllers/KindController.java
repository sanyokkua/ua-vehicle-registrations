package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.KindService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.KindEntity;
import ua.vehicle.registrations.dto.searchable.KindSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class KindController implements BaseRegistrationApi<KindSearchableDto, KindEntity, String> {

    private final KindService service;

    @PostMapping(value = "/search/kinds")
    @Override
    public Page<KindEntity> findRecordsByCriteria(@RequestBody KindSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping(value = "/count/kinds")
    @Override
    public long countRecordsByCriteria(@RequestBody KindSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/kinds")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/kinds/{id}")
    @Override
    public KindEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
