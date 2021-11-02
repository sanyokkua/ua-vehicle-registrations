package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.service.dto.flat.DepartmentFlatDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DepartmentPostgreSqlRepository implements RawSqlRepository<DepartmentFlatDto> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(DepartmentFlatDto entity) {
        jdbcTemplate.update(
                "INSERT INTO DEPARTMENT (DEP_CODE, DEP_NAME) VALUES (:depCode, :depName) ON CONFLICT (DEP_CODE) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
