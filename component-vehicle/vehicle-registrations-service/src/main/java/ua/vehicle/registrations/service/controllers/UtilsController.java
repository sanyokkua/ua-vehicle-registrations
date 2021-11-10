package ua.vehicle.registrations.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.aspects.annotations.SuppressRuntimeExceptions;
import ua.vehicle.registrations.service.dto.SearchEntityDto;
import ua.vehicle.registrations.service.utils.SearchParametersUtils;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utils")
@RequiredArgsConstructor
public class UtilsController {

    @GetMapping("/searchParams")
    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    public List<SearchEntityDto> getSearchParameters() {
        return SearchParametersUtils.getSearchParameters();
    }
}
