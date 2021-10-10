package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Color;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ColorPostgreSqlRepository implements RawSqlRepository<Color> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Color entity) {
        jdbcTemplate.update(
                "INSERT INTO COLOR (COLOR_NAME) VALUES (:colorName) ON CONFLICT (COLOR_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
