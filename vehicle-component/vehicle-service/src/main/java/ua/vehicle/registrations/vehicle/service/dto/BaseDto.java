package ua.vehicle.registrations.vehicle.service.dto;

import lombok.Data;
import ua.vehicle.registrations.vehicle.service.api.CriteriaOperations;

import java.util.List;
import java.util.Map;

@Data
public abstract class BaseDto {

    protected Map<String, List<CriteriaOperations>> possibleOperations;

    public abstract void initPossibleOperations();
}
