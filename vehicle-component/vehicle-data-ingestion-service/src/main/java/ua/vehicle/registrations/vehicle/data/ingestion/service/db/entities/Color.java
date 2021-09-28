package ua.vehicle.registrations.vehicle.data.ingestion.service.db.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("ua_vehicle_registrations.color")
public class Color {

    @Id
    @Column("color_name")
    private String colorName;
}