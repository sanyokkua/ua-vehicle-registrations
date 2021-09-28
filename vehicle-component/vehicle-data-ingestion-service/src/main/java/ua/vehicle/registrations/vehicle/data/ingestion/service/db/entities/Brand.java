package ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_registrations.brand")
public class Brand {

    @Id
    @Column("brand_name")
    private String brandName;
}
