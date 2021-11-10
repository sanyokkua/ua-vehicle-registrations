package ua.vehicle.registrations.data.processing.tasks.abstraction;

public interface Task<I, O> {

    O process(I input);
}
