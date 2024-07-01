package com.ef.inventory.domain.model.commands;


import com.ef.inventory.domain.model.valueobjects.EEquipmentType;

public record CreateEquipmentCommand (String model, EEquipmentType equipmentType){




}
