package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Exchange;
import ru.qelezy.app.repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @GetMapping("/{id}")
    public Exchange findById(@PathVariable Long id) {
        return exchangeRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Exchange exchange) {
        exchangeRepository.save(exchange);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @NotNull Exchange newExchange) {
        Exchange existedExchange = exchangeRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
        newExchange.setId(id);
        exchangeRepository.save(newExchange);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        exchangeRepository.deleteById(id);
    }
}
