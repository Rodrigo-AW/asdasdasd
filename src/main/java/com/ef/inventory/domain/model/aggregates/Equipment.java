package com.ef.inventory.domain.model.aggregates;


import com.ef.inventory.domain.model.commands.CreateEquipmentCommand;
import com.ef.inventory.domain.model.valueobjects.EEquipmentType;
import com.ef.inventory.domain.model.valueobjects.MaterialSerialNumber;
import com.ef.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Equipment extends AuditableAbstractAggregateRoot<Equipment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Embedded
    @Column(name = "material_serial_number")
    private final MaterialSerialNumber materialSerialNumber;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private EEquipmentType equipmentType;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SparePart> spareParts;
    public Equipment() {
        this.materialSerialNumber = new MaterialSerialNumber();
    }

    public Equipment(CreateEquipmentCommand command) {
        this();
        this.model = command.model();

        this.equipmentType = command.equipmentType();
    }



}
