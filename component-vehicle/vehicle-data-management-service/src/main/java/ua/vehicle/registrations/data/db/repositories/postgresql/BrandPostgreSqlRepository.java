package ua.vehicle.registrations.data.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.dto.flat.BrandFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BrandPostgreSqlRepository implements RawSqlRepository<BrandFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(BrandFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO BRAND (BRAND_NAME) VALUES (:brandName) ON CONFLICT (BRAND_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity)
        );
    }
}
