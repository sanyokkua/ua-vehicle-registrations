package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Operation;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OperationPostgreSqlRepository implements RawSqlRepository<Operation> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Operation entity) {
        jdbcTemplate.update(
                "INSERT INTO OPERATION (OP_CODE, OP_NAME) VALUES (:opCode, :opName) ON CONFLICT (OP_CODE) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
