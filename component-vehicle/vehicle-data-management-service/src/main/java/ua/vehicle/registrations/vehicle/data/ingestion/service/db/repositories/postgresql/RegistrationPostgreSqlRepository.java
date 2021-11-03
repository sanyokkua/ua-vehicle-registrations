package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.dto.flat.RegistrationFlatDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RegistrationPostgreSqlRepository implements RawSqlRepository<RegistrationFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(RegistrationFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO REGISTRATION (reg_id, vehicle_id, person_type, person_reg_address, reg_date, reg_number, vin_number, color_name, op_code, dep_code) " +
                        "VALUES (DEFAULT," +
                        "(SELECT V.VEHICLE_ID FROM VEHICLE V WHERE V.BRAND_NAME LIKE :brandName AND V.BRAND_NAME LIKE :brandName AND V.MODEL_NAME LIKE :modelName AND V.BODY_TYPE LIKE :bodyType AND V.KIND_NAME LIKE :kindName AND V.FUEL_TYPE LIKE :fuelType AND V.PURPOSE_NAME LIKE :purposeName AND V.ENGINE_CAPACITY = :engineCapacity AND V.MAKE_YEAR = :makeYear AND V.OWN_WEIGHT = :ownWeight AND V.TOTAL_WEIGHT = :totalWeight LIMIT 1), " +
                        ":personType, " +
                        ":personRegAddress, " +
                        ":regDate, " +
                        ":regNumber, " +
                        ":vinNumber, " +
                        ":colorName, " +
                        ":opCode, " +
                        ":depCode) ON CONFLICT DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
