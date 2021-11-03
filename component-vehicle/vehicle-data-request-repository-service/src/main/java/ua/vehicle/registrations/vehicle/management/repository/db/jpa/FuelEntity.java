package ua.vehicle.registrations.vehicle.management.repository.db.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fuel")
public class FuelEntity {

    @Id
    @Column(name = "fuel_type")
    private String fuelType;
}
