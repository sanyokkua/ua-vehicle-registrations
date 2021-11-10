package ua.vehicle.registrations.data.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.dto.flat.KindFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class KindPostgreSqlRepository implements RawSqlRepository<KindFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(KindFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO KIND (KIND_NAME) VALUES (:kindName) ON CONFLICT (KIND_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity)
        );
    }
}
