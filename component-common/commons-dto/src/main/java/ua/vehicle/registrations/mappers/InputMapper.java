package ua.vehicle.registrations.mappers;

public interface InputMapper<I, O> {

    O map(I source);
}
