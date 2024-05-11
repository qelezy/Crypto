package ru.qelezy.app.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.qelezy.app.entities.Portfolio;
import ru.qelezy.app.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Portfolio findById(@PathVariable Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @NotNull Portfolio newPortfolio) {
        Portfolio existedPortfolio = portfolioRepository.findById(id).orElseThrow(() -> new NullPointerException("Запись с id: " + id + "не найдена"));
        newPortfolio.setId(id);
        portfolioRepository.save(newPortfolio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        portfolioRepository.deleteById(id);
    }
}
