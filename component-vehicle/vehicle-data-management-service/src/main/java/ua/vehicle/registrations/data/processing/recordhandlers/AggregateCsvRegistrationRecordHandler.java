package ua.vehicle.registrations.data.processing.recordhandlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.vehicle.registrations.data.config.QueuesConfig;
import ua.vehicle.registrations.data.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.data.processing.recordhandlers.abstraction.Handler;
import ua.vehicle.registrations.data.processing.recordhandlers.implementations.*;
import ua.vehicle.registrations.data.services.QueueSenderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregateCsvRegistrationRecordHandler {

    private final BodyHandler bodyHandler;
    private final BrandHandler brandHandler;
    private final ColorHandler colorHandler;
    private final DepartmentHandler departmentHandler;
    private final FuelHandler fuelHandler;
    private final KindHandler kindHandler;
    private final ModelHandler modelHandler;
    private final OperationHandler operationHandler;
    private final PurposeHandler purposeHandler;
    private final RegistrationHandler registrationHandler;
    private final VehicleHandler vehicleHandler;
    private final QueueSenderService queueSenderService;
    private final AtomicLong counter = new AtomicLong();
    private List<Handler<CsvVehicleRegistrationRecordDto>> handlers;

    public void handleMessage(CsvVehicleRegistrationRecordDto message) {
        counter.incrementAndGet();
        if (Objects.isNull(handlers) || handlers.isEmpty()) {
            handlers = new ArrayList<>(Arrays.asList(
                    brandHandler,
                    modelHandler,
                    bodyHandler,
                    kindHandler,
                    fuelHandler,
                    purposeHandler,
                    colorHandler,
                    operationHandler,
                    departmentHandler,
                    vehicleHandler,
                    registrationHandler
            ));
        }
        try {
            for (var handler : handlers) {
                handler.handle(message);
            }
            long currentCounter = counter.get();
            if (currentCounter%5000 == 0) {
                log.info("Processed another 5000 messages. Current counter = {}", currentCounter);
            }
        } catch (Exception ex) {
            log.warn("Sending message to DLQ");
            queueSenderService.sendMessage(message, QueuesConfig.DLQ_EXCHANGE, QueuesConfig.DLQ_TOPIC);
        }
    }
}
