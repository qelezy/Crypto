package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.Trend;

@Repository
public interface TrendRepository extends JpaRepository<Trend, Long> {

}
