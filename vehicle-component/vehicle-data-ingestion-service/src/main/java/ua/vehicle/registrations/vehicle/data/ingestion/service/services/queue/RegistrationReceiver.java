package ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

@Slf4j
//@Service
public class RegistrationReceiver extends AbstractReceiver<CsvVehicleRegistrationRecordDto> {

    public RegistrationReceiver(Gson gson, OnMessageListener<CsvVehicleRegistrationRecordDto> listener) {
        super(gson, listener);
    }

    @Override
    public CsvVehicleRegistrationRecordDto map(String message) {
        return gson.fromJson(message, CsvVehicleRegistrationRecordDto.class);
    }
}
