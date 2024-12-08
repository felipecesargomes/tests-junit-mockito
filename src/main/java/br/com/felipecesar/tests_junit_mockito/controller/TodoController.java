package br.com.felipecesar.tests_junit_mockito.controller;

import br.com.felipecesar.tests_junit_mockito.Generics.GenericController;
import br.com.felipecesar.tests_junit_mockito.dto.TodoDTO;
import br.com.felipecesar.tests_junit_mockito.service.TodoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController extends GenericController<TodoDTO, Long> {


    public TodoController(TodoService service) {
        super(service);
    }

}
