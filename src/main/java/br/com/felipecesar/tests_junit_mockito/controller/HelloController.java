package br.com.felipecesar.tests_junit_mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public Map<String, String> helloWorld() {
        return Map.of("message", "Hello World");
    }
}
