package com.ef.inventory.domain.model.commands;


import com.ef.inventory.domain.model.valueobjects.EEquipmentType;

public record CreateEquipmentCommand (String model, EEquipmentType equipmentType){
    public CreateEquipmentCommand {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }
        if (equipmentType == null) {
            throw new IllegalArgumentException("EquipmentType cannot be null");
        }
    }
}