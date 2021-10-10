package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Brand;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BrandPostgreSqlRepository implements RawSqlRepository<Brand> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Brand entity) {
        jdbcTemplate.update(
                "INSERT INTO BRAND (BRAND_NAME) VALUES (:brandName) ON CONFLICT (BRAND_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
