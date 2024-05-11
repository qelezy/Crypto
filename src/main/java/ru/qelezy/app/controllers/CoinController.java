package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {
    @Autowired
    private CoinRepository coinRepository;

    @GetMapping
    public List<Coin> findAll() {
        return coinRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coin findById(@PathVariable Long id) {
        return coinRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Coin coin) {
        coinRepository.save(coin);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @NotNull Coin newCoin) {
        Coin existedCoin = coinRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
        newCoin.setId(id);
        coinRepository.save(newCoin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        coinRepository.deleteById(id);
    }
}
