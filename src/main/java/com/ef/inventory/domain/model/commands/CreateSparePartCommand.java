package com.ef.inventory.domain.model.commands;


public record CreateSparePartCommand ( int supplierId, String model, String supplierProvidedSerialNumber, Integer equipmentId){
}