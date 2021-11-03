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
@Table(name = "operation")
public class OperationEntity {

    @Id
    @Column(name = "op_code")
    private Long opCode;
    @Column(name = "op_name")
    private String opName;
}
