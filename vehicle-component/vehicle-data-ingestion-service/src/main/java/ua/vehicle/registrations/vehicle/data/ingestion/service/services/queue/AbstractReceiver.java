package ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractReceiver<T> implements Receiver<T> {

    protected final Gson gson;
    protected final OnMessageListener<T> listener;

    @Override
    public void process(String message) {
        var dto = map(message);
        listener.onMessage(dto);
    }

}
