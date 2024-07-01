package com.ef.inventory.domain.services;


import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.commands.CreateEquipmentCommand;

import java.util.Optional;

public interface IEquipmentCommandService {

    Optional<Equipment> handle(CreateEquipmentCommand command);

}
