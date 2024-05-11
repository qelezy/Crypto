package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

}
