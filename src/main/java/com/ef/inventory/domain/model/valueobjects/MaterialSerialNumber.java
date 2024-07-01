package com.ef.inventory.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record MaterialSerialNumber(String serialNumber) {
    public MaterialSerialNumber() {
        this(UUID.randomUUID().toString());
    }
    @Override
    public String toString() {
        return serialNumber;
    }

    public MaterialSerialNumber {
        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Material Serial Number cannot be null or blank");
        }
    }
}