package ru.qelezy.app.repositories;

import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.entities.Deal;
import ru.qelezy.app.entities.Portfolio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PortfolioRepository {
    private final List<Portfolio> portfolios = new ArrayList<>();

    public List<Portfolio> findAll() {
        return portfolios;
    }

    @PostConstruct
    private void initialize() {
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin("Bitcoin", "BTC", 50000.0, -25.0, 23.0, 56.0, 2303534050432.0, 4395723867.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)));
        List<Deal> deals = new ArrayList<>();
        deals.add(new Deal("2024-02-02T12:33:33", "sell", 3543256.0, 3.0, "Bitcoin", "BTC"));
        portfolios.add(new Portfolio(coins, deals, List.of(324.0,436.0,584.0,987.0,674.0), List.of(324.0,436.0,584.0,987.0,674.0), 345.0, 345.0));
    }
}
