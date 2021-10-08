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
@Table("fuel")
public class Fuel {

    @Id
    @Column("fuel_type")
    private String fuelType;
}
