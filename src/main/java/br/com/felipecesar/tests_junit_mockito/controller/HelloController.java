package br.com.felipecesar.tests_junit_mockito.controller;

import br.com.felipecesar.tests_junit_mockito.model.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    @Qualifier("motorEletrico")
    private Motor motor;
    @Autowired
    @Qualifier("motorUsado")
    private Motor motor2;

    @GetMapping("/")
    public ResponseEntity<String>
    helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/motor")
    public ResponseEntity<List<Motor>>
    motor() {
        System.out.println("Motor 1: " + motor + ", Motor 2: " + motor2);

        return ResponseEntity.ok(List.of(motor, motor2));
    }
}
