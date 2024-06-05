package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Trend;
import ru.qelezy.app.repositories.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trends")
public class TrendController {
    @Autowired
    private TrendRepository trendRepository;

    @GetMapping
    public List<Trend> findALl() {
        return trendRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Trend> trendOptional = trendRepository.findById(id);
        if (trendOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(trendOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody Trend trend) {
        trendRepository.save(trend);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @NotNull Trend newTrend) {
        Optional<Trend> trendOptional = trendRepository.findById(id);
        if (trendOptional.isPresent()) {
            Trend existingTrend = trendOptional.get();
            existingTrend.setCoins(newTrend.getCoins());
            trendRepository.save(existingTrend);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Optional<Trend> trendOptional = trendRepository.findById(id);
        if (trendOptional.isPresent()) {
            trendRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }
}
