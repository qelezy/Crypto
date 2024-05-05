package ru.qelezy.app.controllers;

import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
