package ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue;

public interface OnMessageListener<T> {

    void onMessage(T message);
}
