package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Optional<Coin> coinOptional = coinRepository.findById(id);
        if (coinOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(coinOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> add(@RequestBody Coin coin) {
        coinRepository.save(coin);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @NotNull Coin newCoin) {
        Optional<Coin> coinOptional = coinRepository.findById(id);
        if (coinOptional.isPresent()) {
            Coin existingCoin = coinOptional.get();
            existingCoin.setCoinName(newCoin.getCoinName());
            existingCoin.setCoinCode(newCoin.getCoinCode());
            existingCoin.setPrice(newCoin.getPrice());
            existingCoin.setOneHourChange(newCoin.getOneHourChange());
            existingCoin.setTwentyFourHoursChange(newCoin.getTwentyFourHoursChange());
            existingCoin.setSevenDaysChange(newCoin.getSevenDaysChange());
            existingCoin.setMarketCap(newCoin.getMarketCap());
            existingCoin.setVolume(newCoin.getVolume());
            existingCoin.setLastPrice(newCoin.getLastPrice());
            coinRepository.save(existingCoin);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        Optional<Coin> coinOptional = coinRepository.findById(id);
        if (coinOptional.isPresent()) {
            coinRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Запись с id: " + id + " не найдена");
        }
    }
}
