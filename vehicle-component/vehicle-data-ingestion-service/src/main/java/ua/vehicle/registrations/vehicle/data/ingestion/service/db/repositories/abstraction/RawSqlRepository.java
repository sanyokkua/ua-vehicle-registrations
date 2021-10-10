package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction;

public interface RawSqlRepository<T> {

    void customInsert(T entity);

    /**
     * Stub implementation
     * <p>
     * return NULL
     */
    default T customFind(T queryEntity) {
        return null;
    }
}
