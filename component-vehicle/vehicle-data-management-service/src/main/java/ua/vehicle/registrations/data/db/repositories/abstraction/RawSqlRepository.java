package ua.vehicle.registrations.data.db.repositories.abstraction;

public interface RawSqlRepository<T> {

    void customInsert(T entity);
}
