package ru.qelezy.app.controllers;

import ru.qelezy.app.entities.Exchange;
import ru.qelezy.app.repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @GetMapping
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }
}
