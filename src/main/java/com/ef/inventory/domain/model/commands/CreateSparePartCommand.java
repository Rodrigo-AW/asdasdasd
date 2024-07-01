package com.ef.inventory.domain.model.commands;


public record CreateSparePartCommand (int supplierId, String model, String supplierProvidedSerialNumber, Integer equipmentId){
    public CreateSparePartCommand {
        if (supplierId <= 0) {
            throw new IllegalArgumentException("SupplierId cannot be less than or equal to 0");
        }

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }
        if (supplierProvidedSerialNumber == null || supplierProvidedSerialNumber.isBlank()) {
            throw new IllegalArgumentException("SupplierProvidedSerialNumber cannot be null or blank");
        }
        if (equipmentId == null) {
            throw new IllegalArgumentException("EquipmentId cannot be null");
        }
    }
}