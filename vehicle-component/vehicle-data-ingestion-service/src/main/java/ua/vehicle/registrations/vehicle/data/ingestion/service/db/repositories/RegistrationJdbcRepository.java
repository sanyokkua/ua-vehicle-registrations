package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Registration;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

import java.time.LocalDate;

@Repository
public interface RegistrationJdbcRepository extends CrudRepository<Registration, Long>, CustomInsertRepository<Registration> {

    @Cacheable(cacheNames = "registration", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);

    @Query("SELECT * FROM "registration" "r" WHERE "
            + ""r"."vehicle_id" = :vehicle_id AND "
            + ""r"."op_code" = :op_code AND "
            + ""r"."dep_code" = :dep_code AND "
            + ""r"."person_reg_address" LIKE :person_reg_address AND "
            + ""r"."reg_date" = :reg_date AND "
            + ""r"."person_type" LIKE :person_type AND "
            + ""r"."reg_number" LIKE :reg_number "
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
