package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

}
