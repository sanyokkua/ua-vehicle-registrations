package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Body;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BodyPostgreSqlRepository implements RawSqlRepository<Body> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Body entity) {
        jdbcTemplate.update(
                "INSERT INTO BODY (BODY_TYPE) VALUES (:bodyType) ON CONFLICT (BODY_TYPE) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
