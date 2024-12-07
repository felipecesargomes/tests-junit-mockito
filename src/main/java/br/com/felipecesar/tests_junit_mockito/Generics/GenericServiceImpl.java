package br.com.felipecesar.tests_junit_mockito.Generics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T, ID> implements IService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        Optional<T> existente = repository.findById(id);
        if (existente.isPresent()) {
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entidade não encontrada.");
        }
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidade não encontrada."));
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

}
