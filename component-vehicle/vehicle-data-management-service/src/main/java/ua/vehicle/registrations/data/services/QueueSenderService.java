package ua.vehicle.registrations.data.services;

import com.google.gson.Gson;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.aspects.annotations.LogInputOutput;
import ua.vehicle.registrations.aspects.annotations.LogTimeMeasures;
import ua.vehicle.registrations.aspects.annotations.SuppressRuntimeExceptions;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final Gson gson;

    @LogInputOutput
    @LogTimeMeasures
    @SuppressRuntimeExceptions
    public void sendMessage(@NonNull Object message, String exchange, String topic) {
        var json = gson.toJson(message);
        rabbitTemplate.convertAndSend(exchange, topic, json);
        log.info("Message sent to queue, exchange: {}, topic: {}, message: {}", exchange, topic, json);
    }
}
