package ua.vehicle.registrations.vehicle.service.dto.jpa;

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
@Table(name = "purpose")
public class PurposeEntity {

    @Id
    @Column(name = "purpose_name")
    private String purposeName;
}
