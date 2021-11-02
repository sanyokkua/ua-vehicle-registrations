package ua.vehicle.registrations.vehicle.service.dto.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "engine_capacity")
    private int engineCapacity;
    @Column(name = "make_year")
    private int makeYear;
    @Column(name = "own_weight")
    private int ownWeight;
    @Column(name = "total_weight")
    private int totalWeight;

    @ManyToOne
    @JoinColumn(name = "brand_name", nullable = false)
    private BrandEntity brand;
    @ManyToOne
    @JoinColumn(name = "model_name", nullable = false)
    private ModelEntity model;
    @ManyToOne
    @JoinColumn(name = "body_type", nullable = false)
    private BodyEntity body;
    @ManyToOne
    @JoinColumn(name = "kind_name", nullable = false)
    private KindEntity kind;
    @ManyToOne
    @JoinColumn(name = "fuel_type", nullable = false)
    private FuelEntity fuel;
    @ManyToOne
    @JoinColumn(name = "purpose_name", nullable = false)
    private PurposeEntity purpose;

}
