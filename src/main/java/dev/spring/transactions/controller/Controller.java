package dev.spring.transactions.controller;

import dev.spring.transactions.service.TransactionService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private TransactionService service;

    public Controller(TransactionService service) {
        this.service = service;
    }
}



