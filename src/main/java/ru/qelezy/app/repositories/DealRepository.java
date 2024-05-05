package ru.qelezy.app.repositories;

import ru.qelezy.app.entities.Deal;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DealRepository {
    private final List<Deal> deals = new ArrayList<>();

    public List<Deal> findAll() {
        return deals;
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    @PostConstruct
    private void initialize() {
        deals.add(new Deal("2024-02-02T12:33:33", "sell", 3543256.0, 3.0, "Bitcoin", "BTC"));
    }
}
