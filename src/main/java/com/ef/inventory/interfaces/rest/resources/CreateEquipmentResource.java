package com.ef.inventory.interfaces.rest.resources;


import com.ef.inventory.domain.model.valueobjects.EEquipmentType;

public record CreateEquipmentResource(String model, EEquipmentType equipmentType) {

}
