package ru.qelezy.app.controllers;

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

    @PostMapping("/add-deal")
    public Deal addDeal(@RequestBody Deal deal) {
        dealRepository.addDeal(deal);
        return dealRepository.findAll().get(dealRepository.findAll().size() - 1);
    }
}
