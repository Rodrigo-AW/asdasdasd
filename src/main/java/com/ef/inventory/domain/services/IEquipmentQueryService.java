package com.ef.inventory.domain.services;

import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.querys.GetEquipmentById;

import java.util.Optional;

public interface IEquipmentQueryService {
    Optional<Equipment> handle(GetEquipmentById id);
}
