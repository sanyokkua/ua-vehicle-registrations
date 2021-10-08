package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs;

public interface CustomInsertRepository<T> {

    <S extends T> S customInsert(S entity);
}
