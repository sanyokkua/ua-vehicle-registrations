package ua.vehicle.registrations.vehicle.management.repository.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.management.repository.services.BrandService;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.vehicle.management.repository.db.jpa.BrandEntity;
import ua.vehicle.registrations.dto.searchable.BrandSearchableDto;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class BrandController implements BaseRegistrationApi<BrandSearchableDto, BrandEntity, String> {

    private final BrandService service;

    @PostMapping(value = "/search/brands")
    @Override
    public Page<BrandEntity> findRecordsByCriteria(@RequestBody BrandSearchableDto searchObject, Pageable pageable) {
        return service.findRecordsByCriteria(searchObject, pageable);
    }

    @PostMapping("/count/brands")
    @Override
    public long countRecordsByCriteria(@RequestBody BrandSearchableDto searchObject) {
        return service.countRecordsByCriteria(searchObject);
    }

    @GetMapping("/count/brands")
    @Override
    public long getNumberOfAllRecords() {
        return service.getNumberOfAllRecords();
    }

    @GetMapping("/brands/{id}")
    @Override
    public BrandEntity findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
