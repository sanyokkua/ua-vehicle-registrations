package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Purpose;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PurposePostgreSqlRepository implements RawSqlRepository<Purpose> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Purpose entity) {
        jdbcTemplate.update(
                "INSERT INTO PURPOSE (PURPOSE_NAME) VALUES (:purposeName) ON CONFLICT (PURPOSE_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
