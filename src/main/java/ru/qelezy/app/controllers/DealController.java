package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import ru.qelezy.app.entities.Deal;
import ru.qelezy.app.repositories.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Deal findById(@PathVariable Long id) {
        return dealRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Deal deal) {
        dealRepository.save(deal);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @NotNull Deal newDeal) {
        Deal existedDeal = dealRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
        newDeal.setId(id);
        dealRepository.save(newDeal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        dealRepository.deleteById(id);
    }
}
