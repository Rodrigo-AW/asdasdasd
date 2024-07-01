package com.ef.inventory.application.internal.services.queryservices;

import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.querys.GetEquipmentById;
import com.ef.inventory.domain.services.IEquipmentQueryService;
import com.ef.inventory.infrastructure.persistence.jpa.IEquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipmentQueryServiceImpl implements IEquipmentQueryService {

        public final IEquipmentRepository equipmentRepository;

    public EquipmentQueryServiceImpl(IEquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Optional<Equipment> handle(GetEquipmentById id) {
    return equipmentRepository.findById(id.id());
    }
}
