package br.com.felipecesar.tests_junit_mockito.Generics;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T, ID> {

    private final IService<T, ID> service;

    public GenericController(IService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

}
