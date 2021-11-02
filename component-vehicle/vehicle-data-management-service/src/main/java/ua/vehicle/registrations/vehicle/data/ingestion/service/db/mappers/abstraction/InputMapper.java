package ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction;

public interface InputMapper<I, O> {

    O map(I source);
}
