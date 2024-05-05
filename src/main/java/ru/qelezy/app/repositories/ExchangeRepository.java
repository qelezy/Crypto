package ru.qelezy.app.repositories;

import ru.qelezy.app.entities.Exchange;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExchangeRepository {
    private final List<Exchange> exchanges = new ArrayList<>();
    public List<Exchange> findAll() {
        return exchanges;
    }

    @PostConstruct
    private void initialize() {
        exchanges.add(new Exchange("Bitcoin", 9.0, 364578658725.0, 67.0, 45.0, List.of(324.0, 436.0, 584.0, 987.0, 674.0)));
    }
}
