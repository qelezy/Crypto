package ru.qelezy.app.repositories;

import ru.qelezy.app.entities.Coin;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoinRepository {
    private final List<Coin> coins = new ArrayList<>();
    public List<Coin> findAll() {
        return coins;
    }

    @PostConstruct
    private void initialize() {
        coins.add(new Coin("Bitcoin", "BTC", 50000.0, -25.0, 23.0, 56.0, 2303534050432.0, 4395723867.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)));
    }
}
