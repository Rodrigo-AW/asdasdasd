package com.ef.inventory.interfaces.rest.resources;


public record SparePartResource(int id, int supplierId, String model, String supplierProvidedSerialNumber,
                                String materialSerialNumber, Integer equipmentId) {
}