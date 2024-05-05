package ru.qelezy.app.controllers;

import ru.qelezy.app.entities.Trend;
import ru.qelezy.app.repositories.TrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
