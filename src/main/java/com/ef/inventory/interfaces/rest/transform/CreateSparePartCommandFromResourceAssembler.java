package com.ef.inventory.interfaces.rest.transform;


import com.ef.inventory.domain.model.commands.CreateSparePartCommand;
import com.ef.inventory.interfaces.rest.resources.CreateSparePartResource;

public class CreateSparePartCommandFromResourceAssembler {
    public static CreateSparePartCommand toCommandFromResource(CreateSparePartResource resource, int equipmentId) {
        return new CreateSparePartCommand(resource.supplierId(), resource.model(), resource.supplierProvidedSerialNumber(), equipmentId) ;
    }
}
