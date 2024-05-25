package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.qelezy.app.entities.Deal;
import ru.qelezy.app.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deals")
public class DealController {
    @Autowired
    private DealRepository dealRepository;

    @GetMapping
    public List<Deal> findAll() {
        return dealRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Deal> dealOptional = dealRepository.findById(id);
        if (dealOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(dealOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody Deal deal) {
        dealRepository.save(deal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @NotNull Deal newDeal) {
        Optional<Deal> dealOptional = dealRepository.findById(id);
        if (dealOptional.isPresent()) {
            newDeal.setId(id);
            dealRepository.save(newDeal);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Optional<Deal> dealOptional = dealRepository.findById(id);
        if (dealOptional.isPresent()) {
            dealRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }
}
