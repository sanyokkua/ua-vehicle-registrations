package ua.vehicle.registrations.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.dto.flat.BrandFlatDto;
import ua.vehicle.registrations.dto.searchable.BrandSearchableDto;
import ua.vehicle.registrations.interfaces.BaseRegistrationApi;
import ua.vehicle.registrations.service.services.BrandService;

@RestController
@RequestMapping("/api/v1/management/registrations")
@RequiredArgsConstructor
public class BrandController implements BaseRegistrationApi<BrandSearchableDto, BrandFlatDto, String> {

    private final BrandService service;

    @PostMapping(value = "/search/brands")
    @Override
    public Page<BrandFlatDto> findRecordsByCriteria(@RequestBody BrandSearchableDto searchObject, Pageable pageable) {
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
    public BrandFlatDto findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
