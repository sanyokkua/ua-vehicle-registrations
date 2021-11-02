package ua.vehicle.registrations.vehicle.service.api;

public interface BaseVehicleApiWithId<I, O, T> extends BaseVehicleApi<I, O> {

    O findRecord(T id);

}
