package ua.vehicle.registrations.data.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.dto.flat.PurposeFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PurposePostgreSqlRepository implements RawSqlRepository<PurposeFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(PurposeFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO PURPOSE (PURPOSE_NAME) VALUES (:purposeName) ON CONFLICT (PURPOSE_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity)
        );
    }
}
