package br.com.felipecesar.tests_junit_mockito.service;

import br.com.felipecesar.tests_junit_mockito.Generics.GenericService;
import br.com.felipecesar.tests_junit_mockito.dto.TodoDTO;
import br.com.felipecesar.tests_junit_mockito.model.TodoEntity;
import br.com.felipecesar.tests_junit_mockito.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TodoService extends GenericService<TodoDTO, TodoEntity, Long> {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, TodoEntity.class, TodoDTO.class);
        this.repository = repository;
    }

}