package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Vehicle;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class VehiclePostgreSqlRepository implements RawSqlRepository<Vehicle> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Vehicle entity) {
        jdbcTemplate.update(
                "INSERT INTO VEHICLE (VEHICLE_ID, BRAND_NAME, MODEL_NAME, BODY_TYPE, KIND_NAME, FUEL_TYPE, PURPOSE_NAME, ENGINE_CAPACITY, MAKE_YEAR, OWN_WEIGHT, TOTAL_WEIGHT) " +
                        "VALUES (DEFAULT," +
                        ":brandName, " +
                        ":modelName, " +
                        ":bodyType, " +
                        ":kindName, " +
                        ":fuelType, " +
                        ":purposeName, " +
                        ":engineCapacity, " +
                        ":makeYear, " +
                        ":ownWeight, " +
                        ":totalWeight) ON CONFLICT (VEHICLE_ID) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }

    @Cacheable(cacheNames = "findVehicleTemplate", unless = "#result == null", key = "#vehicle.hashCode()")
    @Override
    public Vehicle customFind(Vehicle vehicle) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM VEHICLE v WHERE "
                                                       + "v.BRAND_NAME LIKE :brandName AND "
                                                       + "v.MODEL_NAME LIKE :modelName AND "
                                                       + "v.BODY_TYPE LIKE :bodyType AND "
                                                       + "v.KIND_NAME LIKE :kindName AND "
                                                       + "v.FUEL_TYPE LIKE :fuelType AND "
                                                       + "v.ENGINE_CAPACITY = :engineCapacity AND "
                                                       + "v.MAKE_YEAR = :makeYear AND "
                                                       + "v.OWN_WEIGHT = :ownWeight AND "
                                                       + "v.TOTAL_WEIGHT = :totalWeight",
                                               new BeanPropertySqlParameterSource(vehicle), new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
