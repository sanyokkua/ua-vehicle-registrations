package ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.GeneralCsvRegistrationRecordHandler;

@Slf4j
@RequiredArgsConstructor
public class DlqMessageListenerListener implements OnMessageListener<CsvVehicleRegistrationRecordDto> {

    private final GeneralCsvRegistrationRecordHandler generalCsvRegistrationRecordHandler;

    @Override
    public void onMessage(CsvVehicleRegistrationRecordDto message) {
        generalCsvRegistrationRecordHandler.handleMessage(message);
        log.warn("Message from DLQ {}", message);
    }
}
