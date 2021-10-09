package ua.vehicle.registrations.vehicle.data.ingestion.service.handlers;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ua.vehicle.registrations.vehicle.data.ingestion.service.config.QueuesConfig;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.abstraction.Handler;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.QueueSenderService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
@RequiredArgsConstructor
public class GeneralCsvRegistrationRecordHandler {
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
    private List<Handler<CsvVehicleRegistrationRecordDto>> basicHandlers;

    @Synchronized
    public void handleMessage(CsvVehicleRegistrationRecordDto message) {
        counter.incrementAndGet();
        if (Objects.isNull(basicHandlers) || basicHandlers.isEmpty()) {
            basicHandlers = new LinkedList<>();
            basicHandlers.addAll(Arrays.asList(
                    brandHandler,
                    modelHandler,
                    bodyHandler,
                    kindHandler,
                    fuelHandler,
                    purposeHandler,
                    colorHandler,
                    operationHandler,
                    departmentHandler
            ));
        }
        try {
            for (var handler : basicHandlers) {
                handler.handle(message);
            }
            vehicleHandler.handle(message);
            registrationHandler.handle(message);
        } catch (Exception ex) {
            log.warn("Sending message to DLQ");
            queueSenderService.sendMessage(message, QueuesConfig.DLQ_EXCHANGE, QueuesConfig.DLQ_TOPIC);
        }
        long currentCounter = counter.get();
        if (currentCounter % 5000 == 0) {
            log.info("Processed another 5000 messages. Current counter = {}", currentCounter);
        }
    }
}
