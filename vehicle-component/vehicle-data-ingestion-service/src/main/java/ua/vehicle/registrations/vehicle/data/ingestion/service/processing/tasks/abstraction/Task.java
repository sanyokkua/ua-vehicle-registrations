package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.tasks.abstraction;

public interface Task<I, O> {

    O process(I input);
}