package br.com.felipecesar.tests_junit_mockito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<String>
    helloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}
