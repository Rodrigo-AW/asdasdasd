package com.ef.inventory.domain.services;


import com.ef.inventory.domain.model.aggregates.SparePart;
import com.ef.inventory.domain.model.commands.CreateSparePartCommand;

import java.util.Optional;

public interface ISparePartCommandService {
    Optional<SparePart> handle(CreateSparePartCommand command);
}
