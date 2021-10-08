package ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("vehicle")
public class Vehicle {

    @Id
    @Column("vehicle_id")
    private Long vehicleId;
    @Column("brand_name")
    private String brandName;
    @Column("model_name")
    private String modelName;
    @Column("body_type")
    private String bodyType;
    @Column("kind_name")
    private String kindName;
    @Column("fuel_type")
    private String fuelType;
    @Column("purpose_name")
    private String purposeName;
    @Column("engine_capacity")
    private int engineCapacity;
    @Column("make_year")
    private int makeYear;
    @Column("own_weight")
    private int ownWeight;
    @Column("total_weight")
    private int totalWeight;
}
