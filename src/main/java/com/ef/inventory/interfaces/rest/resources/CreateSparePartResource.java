package com.ef.inventory.interfaces.rest.resources;


public record CreateSparePartResource(int supplierId, String model, String supplierProvidedSerialNumber) {
}
