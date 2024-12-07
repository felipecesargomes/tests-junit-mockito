package br.com.felipecesar.tests_junit_mockito.Generics;

import java.util.List;

public interface IService<T, ID> {
    T save(T entity);             // Salva a entidade fornecida e retorna a entidade salva
    T update(ID id, T entity);    // Atualiza a entidade identificada pelo ID
    void delete(ID id);           // Deleta uma entidade identificada pelo ID
    T findById(ID id);            // Busca uma entidade pelo ID
    List<T> findAll();            // Retorna uma lista de todas as entidades
}
