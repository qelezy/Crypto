package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.Coin;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

}
