package com.example.dockermultistagebuild.controller;

import com.example.dockermultistagebuild.domain.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public Transaction getTransaction() {
        final Transaction transaction = new Transaction();
        final UUID id = UUID.randomUUID();
        transaction.setId(id);
        transaction.setTxCode(id.toString().replace("-", ""));
        transaction.setSum(Math.random() * 1000);
        return transaction;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void healthCheck() {
        
    }
}