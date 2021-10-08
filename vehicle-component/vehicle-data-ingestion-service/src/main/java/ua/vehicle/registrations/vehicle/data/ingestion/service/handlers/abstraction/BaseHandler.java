package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public abstract class BaseHandler<T> implements Handler<T> {

    @Override
    public void handle(T obj) {
        try {
            if (Objects.isNull(obj)) {
                throw new NullPointerException("Object is null. Will not be handled");
            }
            process(obj);
        } catch (Exception ex) {
            log.warn("Exception occurred due processing record {}", obj, ex);
            throw new RuntimeException("Problem with processing record.", ex);
        }
    }

    protected abstract void process(T obj);


}
