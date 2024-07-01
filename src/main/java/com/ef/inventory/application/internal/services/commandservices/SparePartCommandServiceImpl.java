package com.ef.inventory.application.internal.services.commandservices;


import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.aggregates.SparePart;
import com.ef.inventory.domain.model.commands.CreateSparePartCommand;
import com.ef.inventory.domain.services.ISparePartCommandService;
import com.ef.inventory.infrastructure.persistence.jpa.IEquipmentRepository;
import com.ef.inventory.infrastructure.persistence.jpa.ISparePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartCommandServiceImpl implements ISparePartCommandService {
    private final ISparePartRepository sparePartRepository;
    private final IEquipmentRepository equipmentRepository;

    public SparePartCommandServiceImpl(ISparePartRepository sparePartRepository, IEquipmentRepository equipmentRepository) {
        this.sparePartRepository = sparePartRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Optional<SparePart> handle(CreateSparePartCommand command) {

        Optional<Equipment> equipment = equipmentRepository.findById(command.equipmentId());
        if (equipment.isEmpty()) {
            throw new RuntimeException("Equipment not found");

        }

        List<SparePart> existingSpareParts = sparePartRepository.findBySupplierIdAndModelAndSupplierProvidedSerialNumber(command.supplierId(), command.model(), command.supplierProvidedSerialNumber());
        if (!existingSpareParts.isEmpty()) {
            throw new IllegalArgumentException("Spare part with the same serial number already exists");
        }

        SparePart sparePart = new SparePart(command, equipment.get());
        sparePart.setMaterialSerialNumber(equipment.get().getMaterialSerialNumber().toString());
        sparePartRepository.save(sparePart);
        return Optional.of(sparePart);

    }
}
