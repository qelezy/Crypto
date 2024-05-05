package ru.qelezy.app.controllers;

import ru.qelezy.app.entities.Portfolio;
import ru.qelezy.app.repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @GetMapping
    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }
}
