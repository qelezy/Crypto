package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Exchange;
import ru.qelezy.app.repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Exchange> exchangeOptional = exchangeRepository.findById(id);
        if (exchangeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(exchangeOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody Exchange exchange) {
        exchangeRepository.save(exchange);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @NotNull Exchange newExchange) {
        Optional<Exchange> exchangeOptional = exchangeRepository.findById(id);
        if (exchangeOptional.isPresent()) {
            newExchange.setId(id);
            exchangeRepository.save(newExchange);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Optional<Exchange> exchangeOptional = exchangeRepository.findById(id);
        if (exchangeOptional.isPresent()) {
            exchangeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }
}
