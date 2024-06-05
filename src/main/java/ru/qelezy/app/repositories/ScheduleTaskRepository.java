package ru.qelezy.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qelezy.app.entities.ScheduleTask;

@Repository
public interface ScheduleTaskRepository extends JpaRepository<ScheduleTask, Long> {
}
