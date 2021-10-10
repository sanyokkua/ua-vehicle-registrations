package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Kind;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class KindPostgreSqlRepository implements RawSqlRepository<Kind> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Kind entity) {
        jdbcTemplate.update(
                "INSERT INTO KIND (KIND_NAME) VALUES (:kindName) ON CONFLICT (KIND_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
