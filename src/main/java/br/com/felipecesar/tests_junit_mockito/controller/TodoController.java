package br.com.felipecesar.tests_junit_mockito.controller;

import br.com.felipecesar.tests_junit_mockito.Generics.GenericController;
import br.com.felipecesar.tests_junit_mockito.model.TodoEntity;
import br.com.felipecesar.tests_junit_mockito.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController extends GenericController<TodoEntity, Integer> {

    public TodoController(TodoServiceImpl service) {
        super(service);
    }

}
