package com.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matt on 23.04.2019 at 19:29.
 */
@RestController
class TestController {

    private final InsertRepository insertRepository;

    @GetMapping("/")
    String test() {
        return "Test no. 2 passed!";
    }

    @GetMapping("/inserts")
    Iterable<Insert> inserts() {
        return insertRepository.findAll();
    }

    public TestController(InsertRepository insertRepository) {
        this.insertRepository = insertRepository;
    }
}
