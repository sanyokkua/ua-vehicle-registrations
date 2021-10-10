package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Fuel;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FuelPostgreSqlRepository implements RawSqlRepository<Fuel> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Fuel entity) {
        jdbcTemplate.update(
                "INSERT INTO FUEL (FUEL_TYPE) VALUES (:fuelType) ON CONFLICT (FUEL_TYPE) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
