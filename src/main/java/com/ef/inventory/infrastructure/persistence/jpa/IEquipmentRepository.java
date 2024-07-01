package com.ef.inventory.infrastructure.persistence.jpa;


import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.valueobjects.MaterialSerialNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEquipmentRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findByMaterialSerialNumber(MaterialSerialNumber materialSerialNumber);






}
