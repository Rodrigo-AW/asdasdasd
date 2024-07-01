package com.ef.inventory.interfaces.rest.resources;


import com.ef.inventory.domain.model.valueobjects.EEquipmentType;

public record EquipmentResource(int id, String model, EEquipmentType equipmentType, String materialSerialNumber) {

}
