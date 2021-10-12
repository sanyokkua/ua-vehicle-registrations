package ua.vehicle.registrations.vehicle.service.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class SearchQuery {

    @Builder.Default
    private Set<Criteria<?>> criteriaSet = new HashSet<>();

    public void addCriteria(Criteria<?> criteria) {
        criteriaSet.add(criteria);
    }

    public void addAllCriteria(List<Criteria<?>> criteriaList) {
        criteriaSet.addAll(criteriaList);
    }
}
