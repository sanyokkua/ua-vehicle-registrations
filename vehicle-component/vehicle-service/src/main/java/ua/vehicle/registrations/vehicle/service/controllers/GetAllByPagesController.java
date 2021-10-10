package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.registrations.vehicle.service.dto.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class GetAllByPagesController {

    @GetMapping(path = "/bodies", params = {"page", "size"})
    public List<Body> getAllBodies(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/brands", params = {"page", "size"})
    public List<Brand> getAllBrands(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/colors", params = {"page", "size"})
    public List<Color> getAllColors(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/departments", params = {"page", "size"})
    public List<Department> getAllDepartmets(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/fuel_types", params = {"page", "size"})
    public List<Fuel> getAllFuelTypes(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/kinds", params = {"page", "size"})
    public List<Kind> getAllKinds(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/models", params = {"page", "size"})
    public List<Model> getAllModels(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/operations", params = {"page", "size"})
    public List<Operation> getAllOperations(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/purposes", params = {"page", "size"})
    public List<Purpose> getAllPurposes(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/vehicles", params = {"page", "size"})
    public List<Vehicle> getAllVehicles(Pageable pageable) {
        return Collections.emptyList();
    }

    @GetMapping(path = "/registrations", params = {"page", "size"})
    public List<Registration> getAllRegistrations(Pageable pageable) {
        return Collections.emptyList();
    }

}
