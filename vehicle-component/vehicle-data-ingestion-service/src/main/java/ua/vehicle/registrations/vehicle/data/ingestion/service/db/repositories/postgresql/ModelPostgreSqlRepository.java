package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.postgresql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Model;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ModelPostgreSqlRepository implements RawSqlRepository<Model> {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void customInsert(Model entity) {
        jdbcTemplate.update(
                "INSERT INTO MODEL (MODEL_NAME) VALUES (:modelName) ON CONFLICT (MODEL_NAME) DO NOTHING",
                new BeanPropertySqlParameterSource(entity));
    }
}
