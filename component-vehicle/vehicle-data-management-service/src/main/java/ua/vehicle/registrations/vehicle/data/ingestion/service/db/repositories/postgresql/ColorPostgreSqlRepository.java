package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.dto.flat.ColorFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ColorPostgreSqlRepository implements RawSqlRepository<ColorFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(ColorFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO COLOR (COLOR_NAME) VALUES (:colorName) ON CONFLICT (COLOR_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
