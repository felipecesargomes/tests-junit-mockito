package br.com.felipecesar.tests_junit_mockito.Generics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

public abstract class GenericController<DTO, ID> {

    private final IService<DTO, ID> service;

    public GenericController(IService<DTO, ID> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DTO> save(@Valid @RequestBody DTO dto) {
        DTO savedDto = service.save(dto);
        return ResponseEntity.status(201).body(savedDto);
    }


    @PutMapping("/{id}")
    //@Operation(summary = "Update an entity", description = "Updates an existing entity based on the provided DTO.")
    public ResponseEntity<DTO> update(@PathVariable ID id, @Valid @RequestBody DTO dto) {
        DTO updatedDto = service.update(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    //@Operation(summary = "Delete an entity", description = "Deletes an entity by ID.")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    //@Operation(summary = "Find an entity by ID", description = "Retrieves an entity by its ID.")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        DTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    //@Operation(summary = "List all entities", description = "Retrieves a list of all entities.")
    public ResponseEntity<List<DTO>> findAll() {
        List<DTO> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }
}
