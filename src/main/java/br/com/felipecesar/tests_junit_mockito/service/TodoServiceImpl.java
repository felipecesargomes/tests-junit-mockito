package br.com.felipecesar.tests_junit_mockito.service;

import br.com.felipecesar.tests_junit_mockito.Generics.GenericServiceImpl;
import br.com.felipecesar.tests_junit_mockito.model.TodoEntity;
import br.com.felipecesar.tests_junit_mockito.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl extends GenericServiceImpl<TodoEntity, Integer>  {

    private final TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        super(repository);
        this.repository = repository;
    }

}