package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseVehicleApiWithId;
import ua.vehicle.registrations.vehicle.service.dto.flat.KindFlatDto;
import ua.vehicle.registrations.vehicle.service.dto.searchable.KindSearchableDto;
import ua.vehicle.registrations.vehicle.service.services.KindService;

@RestController
@RequestMapping("/api/v1/registrationRecords")
@RequiredArgsConstructor
public class KindController implements BaseVehicleApiWithId<KindSearchableDto, KindFlatDto, String> {

    private final KindService service;

    @PostMapping(value = "/search/kinds")
    @Override
    public Page<KindFlatDto> findRecordsByCriteria(@RequestBody KindSearchableDto searchObject, Pageable pageable) {
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
    public KindFlatDto findRecord(@PathVariable String id) {
        return service.findRecord(id);
    }
}
