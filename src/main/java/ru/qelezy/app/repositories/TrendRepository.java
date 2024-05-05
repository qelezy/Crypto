package ru.qelezy.app.repositories;

import ru.qelezy.app.entities.Trend;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrendRepository {
    private final List<Trend> trends = new ArrayList<>();
    public List<Trend> findAll() {
        return trends;
    }

    @PostConstruct
    private void initialize() {
        trends.add(new Trend("Bitcoin", "BTC", 23.0));
        trends.add(new Trend("Bitcoin", "BTC", 23.0));
    }
}
