package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction;

public interface RawSqlRepository<T> {

    void customInsert(T entity);
}
