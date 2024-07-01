package com.ef.inventory.infrastructure.persistence.jpa;


import com.ef.inventory.domain.model.aggregates.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISparePartRepository extends JpaRepository<SparePart, Integer> {
    List<SparePart> findBySupplierIdAndModelAndSupplierProvidedSerialNumber(int supplierId, String model, String supplierProvidedSerialNumber);
}
