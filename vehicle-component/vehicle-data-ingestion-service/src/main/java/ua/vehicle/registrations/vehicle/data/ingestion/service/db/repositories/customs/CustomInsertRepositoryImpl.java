package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomInsertRepositoryImpl<T> implements CustomInsertRepository<T> {

    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    @Override
    public <S extends T> S customInsert(S entity) {
        return jdbcAggregateTemplate.insert(entity);
    }
}
