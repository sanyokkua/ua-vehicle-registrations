package ua.vehicle.registrations.vehicle.data.ingestion.service.processing.recordhandlers.abstraction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.mappers.abstraction.BaseCsvVehicleRegistrationRecordMapper;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.abstraction.RawSqlRepository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public abstract class RegistrationBaseHandler<T> implements Handler<CsvVehicleRegistrationRecordDto> {

    protected final RawSqlRepository<T> repository;
    protected final BaseCsvVehicleRegistrationRecordMapper<T> mapper;

    @Override
    public void handle(CsvVehicleRegistrationRecordDto recordToHandle) {
        try {
            if (Objects.isNull(recordToHandle)) {
                throw new NullPointerException("Object is null. Will not be handled");
            }
            process(recordToHandle);
        } catch (Exception ex) {
            log.warn("Exception occurred due processing record {}", recordToHandle, ex);
            throw new HandlingRecordException("Problem with processing record.", ex);
        }
    }

    protected void process(CsvVehicleRegistrationRecordDto obj) {
        var mapped = mapper.map(obj);
        repository.customInsert(mapped);
    }
}
