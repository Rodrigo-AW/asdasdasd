package com.ef.inventory.interfaces.rest.transform;


import com.ef.inventory.domain.model.aggregates.SparePart;
import com.ef.inventory.interfaces.rest.resources.SparePartResource;

public class SparePartResourceFromEntityAssembler {

    public static SparePartResource toResourceFromEntity(SparePart entity) {
        Integer equipmentId = null;
        if (entity.getEquipment() != null) {
            equipmentId = entity.getEquipment().getId();
        }
        return new SparePartResource(entity.getId(), entity.getSupplierId(), entity.getModel(),
                entity.getSupplierProvidedSerialNumber(), entity.getMaterialSerialNumber(), equipmentId);
    }

}
