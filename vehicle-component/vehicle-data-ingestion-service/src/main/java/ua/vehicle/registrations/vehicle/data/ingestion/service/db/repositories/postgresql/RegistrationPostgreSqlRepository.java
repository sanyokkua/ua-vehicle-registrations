package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Registration;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RegistrationPostgreSqlRepository implements RawSqlRepository<Registration> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Registration entity) {
        jdbcTemplate.update(
                "INSERT INTO REGISTRATION (reg_id, vehicle_id, person_type, person_reg_address, reg_date, reg_number, vin_number, color_name, op_code, dep_code) " +
                        "VALUES (DEFAULT," +
                        ":vehicleId, " +
                        ":personType, " +
                        ":personRegAddress, " +
                        ":regDate, " +
                        ":regNumber, " +
                        ":vinNumber, " +
                        ":colorName, " +
                        ":opCode, " +
                        ":depCode) ON CONFLICT (REG_ID) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }

    @Cacheable(cacheNames = "findRegistrationTemplate", unless = "#result == null", key = "#registration.hashCode()")
    @Override
    public Registration customFind(Registration registration) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM REGISTRATION r WHERE "
                                                       + "r.VEHICLE_ID = :vehicleId AND "
                                                       + "r.OP_CODE = :opCode AND "
                                                       + "r.DEP_CODE = :depCode AND "
                                                       + "r.PERSON_REG_ADDRESS LIKE :personRegAddress AND "
                                                       + "r.REG_DATE = :regDate AND "
                                                       + "r.PERSON_TYPE LIKE :personType AND "
                                                       + "r.REG_NUMBER LIKE :regNumber",
                                               new BeanPropertySqlParameterSource(registration), new BeanPropertyRowMapper<Registration>(Registration.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
