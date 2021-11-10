package ua.vehicle.registrations.data.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.data.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.dto.flat.FuelFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FuelPostgreSqlRepository implements RawSqlRepository<FuelFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(FuelFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO FUEL (FUEL_TYPE) VALUES (:fuelType) ON CONFLICT (FUEL_TYPE) DO NOTHING",
                new BeanPropertySqlParameterSource(entity)
        );
    }
}
