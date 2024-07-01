package com.ef.inventory.interfaces.rest.transform;


import com.ef.inventory.domain.model.commands.CreateEquipmentCommand;
import com.ef.inventory.interfaces.rest.resources.CreateEquipmentResource;

public class CreateEquipmentCommandFromResourceAssembler {
    public static CreateEquipmentCommand toCommandFromResource (CreateEquipmentResource resource) {
        return new CreateEquipmentCommand(resource.model(), resource.equipmentType());
    }
}
