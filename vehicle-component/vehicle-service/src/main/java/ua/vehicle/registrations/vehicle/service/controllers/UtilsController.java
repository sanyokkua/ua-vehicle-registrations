package ua.vehicle.registrations.vehicle.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.registrations.vehicle.service.dto.SearchParametersDto;
import ua.vehicle.registrations.vehicle.service.services.UtilsService;

@RestController
@RequestMapping("/api/v1/utils")
@RequiredArgsConstructor
public class UtilsController {

    private final UtilsService utilsService;

    @GetMapping("/searchParams")
    public SearchParametersDto getSearchParams() {
        return utilsService.getSearchParameters();
    }
}
