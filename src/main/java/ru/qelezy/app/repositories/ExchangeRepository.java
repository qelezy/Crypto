package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

}
