package ua.vehicle.registrations.data.processing.recordhandlers.abstraction;

public interface Handler<T> {

    void handle(T recordToHandle);
}
