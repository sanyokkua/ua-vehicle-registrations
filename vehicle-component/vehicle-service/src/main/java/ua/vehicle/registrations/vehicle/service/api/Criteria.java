package ua.vehicle.registrations.vehicle.service.api;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class Criteria<T> {

    protected final String fieldName;
    protected final T value;
    protected final T lowRange;
    protected final T highRange;
    @Builder.Default
    protected final List<CriteriaOperations> operations = new ArrayList<>();

    public void addOperation(CriteriaOperations operation) {
        operations.add(operation);
    }
}
