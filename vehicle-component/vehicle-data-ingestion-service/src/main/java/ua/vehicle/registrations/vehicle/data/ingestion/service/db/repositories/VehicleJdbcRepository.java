package ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities.Vehicle;
import ua.vehicle.registrations.vehicle.data.ingestion.service.db.repositories.customs.CustomInsertRepository;

@Repository
public interface VehicleJdbcRepository extends CrudRepository<Vehicle, Long>, CustomInsertRepository<Vehicle> {

    @Cacheable(cacheNames = "vehicle", unless = "#result == false ", key = "#aLong.hashCode()")
    @Override
    boolean existsById(Long aLong);

    @Query("SELECT * FROM vehicle v WHERE "
            + "v.brand_name LIKE :brand AND "
            + "v.model_name LIKE :model AND "
            + "v.body_type LIKE :body AND "
            + "v.kind_name LIKE :kind AND "
            + "v.fuel_type LIKE :fuel AND "
            + "v.engine_capacity = :engine_capacity AND "
            + "v.make_year = :make_year AND "
            + "v.own_weight = :own_weight AND "
            + "v.total_weight = :total_weight"
    )
    Vehicle findByFields(@Param("brand") String brand,
                         @Param("model") String model,
                         @Param("body") String body,
                         @Param("kind") String kind,
                         @Param("fuel") String fuel,
                         @Param("engine_capacity") Integer engineCapacity,
                         @Param("make_year") Integer makeYear,
                         @Param("own_weight") Integer ownWeight,
                         @Param("total_weight") Integer totalWeight
    );

    @Cacheable(cacheNames = "findVehicle", unless = "#result == null", key = "#vehicle.hashCode()")
    default Vehicle findVehicle(Vehicle vehicle) {
        return findByFields(vehicle.getBrandName(),
                            vehicle.getModelName(),
                            vehicle.getBodyType(),
                            vehicle.getKindName(),
                            vehicle.getFuelType(),
                            vehicle.getEngineCapacity(),
                            vehicle.getMakeYear(),
                            vehicle.getOwnWeight(),
                            vehicle.getTotalWeight());
    }
}
