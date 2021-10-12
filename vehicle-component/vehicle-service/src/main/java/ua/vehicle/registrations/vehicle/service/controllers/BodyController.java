package ua.vehicle.registrations.vehicle.service.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ua.vehicle.registrations.vehicle.service.api.BaseEntityControllerApi;
import ua.vehicle.registrations.vehicle.service.api.SearchQuery;
import ua.vehicle.registrations.vehicle.service.dto.Body;

@RestController
@RequestMapping("/api/v1/registrationRecords")
public class BodyController implements BaseEntityControllerApi<Body, String> {

    @PostMapping("/search/bodies")
    @Override
    public Page<Body> findRecordsByCriteria(@RequestBody SearchQuery searchQuery, Pageable pageable) {
        return null;
    }

    @PostMapping("count/bodies")
    @Override
    public int countRecordsByCriteria(@RequestBody SearchQuery searchQuery) {
        return 0;
    }

    @GetMapping("count/bodies")
    @Override
    public int getNumberOfAllRecords() {
        return 0;
    }

    @GetMapping("/bodies/{id}")
    @Override
    public Body findRecord(String id) {
        return null;
    }
}
