package com.ef.inventory.interfaces.rest.transform;


import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.interfaces.rest.resources.EquipmentResource;

public class EquipmentResourceFromEntityAssembler {
    public static EquipmentResource toResourceFromEntity(Equipment entity) {
        return new EquipmentResource(entity.getId(), entity.getModel(), entity.getEquipmentType(), entity.getMaterialSerialNumber().toString());
    }
}
