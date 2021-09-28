package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Registration;

import java.time.LocalDate;

@Repository
public interface RegistrationJdbcRepository extends CrudRepository<Registration, Long> {

    @Cacheable(cacheNames = "registration", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);

    @Query("select * from ua_vehicle_registrations.registration r where "
            + "r.dep_code = :dep_code and "
            + "r.person_reg_address like :person_reg_address and "
            + "r.oper_code = :op_code and "
            + "r.vehicle_id = :vehicle_id and "
            + "r.reg_date = :reg_date and "
            + "r.person_type like :person_type and "
            + "r.reg_number like :reg_number "
    )
    Registration findByFields(@Param("dep_code") Long depCode,
                              @Param("person_reg_address") String personRegAddress,
                              @Param("op_code") Long opCode,
                              @Param("vehicle_id") Long vehicleId,
                              @Param("reg_date") LocalDate regDate,
                              @Param("person_type") String personType,
                              @Param("reg_number") String regNumber
    );

    @Cacheable(cacheNames = "findRegistration", unless = "#result == null", key = "#registration.hashCode()")
    default Registration findRegistration(Registration registration) {
        return findByFields(registration.getDepCode(),
                registration.getPersonRegAddress(),
                registration.getOpCode(),
                registration.getVehicleId(),
                registration.getRegDate(),
                registration.getPersonType(),
                registration.getRegNumber());
    }
}
