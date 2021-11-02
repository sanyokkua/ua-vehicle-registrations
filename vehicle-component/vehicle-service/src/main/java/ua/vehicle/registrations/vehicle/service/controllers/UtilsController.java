package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.registrations.vehicle.service.dto.SearchEntityDto;
import ua.vehicle.registrations.vehicle.service.services.UtilsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utils")
@RequiredArgsConstructor
public class UtilsController {

    private final UtilsService utilsService;

    @GetMapping("/searchParams")
    public List<SearchEntityDto> getSearchParameters() {
        return utilsService.getSearchParameters();
    }
}
