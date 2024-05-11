package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Trend;
import ru.qelezy.app.repositories.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public Trend findById(@PathVariable Long id) {
        return trendRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Trend trend) {
        trendRepository.save(trend);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @NotNull Trend newTrend) {
        Trend existedTrend = trendRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
        newTrend.setId(id);
        trendRepository.save(newTrend);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        trendRepository.deleteById(id);
    }
}
