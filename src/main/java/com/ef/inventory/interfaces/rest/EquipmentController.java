package com.ef.inventory.interfaces.rest;


import com.ef.inventory.domain.model.aggregates.Equipment;
import com.ef.inventory.domain.model.querys.GetEquipmentById;
import com.ef.inventory.domain.services.IEquipmentCommandService;
import com.ef.inventory.domain.services.IEquipmentQueryService;
import com.ef.inventory.interfaces.rest.resources.CreateEquipmentResource;
import com.ef.inventory.interfaces.rest.resources.EquipmentResource;
import com.ef.inventory.interfaces.rest.transform.CreateEquipmentCommandFromResourceAssembler;
import com.ef.inventory.interfaces.rest.transform.EquipmentResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/equipments", produces =  MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {

        private final IEquipmentCommandService equipmentCommandService;
        private final IEquipmentQueryService equipmentQueryService;

        public EquipmentController(IEquipmentCommandService equipmentCommandService, IEquipmentQueryService equipmentQueryService) {
            this.equipmentCommandService = equipmentCommandService;
            this.equipmentQueryService = equipmentQueryService;
        }

    @PostMapping
    public ResponseEntity<EquipmentResource> createEquipment(@RequestBody CreateEquipmentResource resource) {
        Optional<Equipment> equipment = equipmentCommandService.handle(CreateEquipmentCommandFromResourceAssembler.toCommandFromResource(resource));
        return equipment.map(resp ->
                        new ResponseEntity<>(EquipmentResourceFromEntityAssembler
                                .toResourceFromEntity(resp), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResource>getFarmById(@PathVariable int id){
        Optional<Equipment> farm = equipmentQueryService.handle(new GetEquipmentById(id));
        return farm.map(resp->ResponseEntity.ok(EquipmentResourceFromEntityAssembler.toResourceFromEntity(resp)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }


}
