package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.service.dto.flat.VehicleFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class VehiclePostgreSqlRepository implements RawSqlRepository<VehicleFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(VehicleFlatDto entity) {
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
                        ":totalWeight) ON CONFLICT DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}