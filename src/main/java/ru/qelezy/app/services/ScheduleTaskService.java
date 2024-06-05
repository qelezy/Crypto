package ru.qelezy.app.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qelezy.app.entities.ScheduleTask;
import ru.qelezy.app.repositories.ScheduleTaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleTaskService {
    @Autowired
    private ScheduleTaskRepository scheduleTaskRepository;

    @Transactional
    public void saveScheduleTask(boolean isSuccess) {
        ScheduleTask scheduleTask = new ScheduleTask();
        scheduleTask.setUpdateDateTime(LocalDateTime.now());
        scheduleTask.setSuccess(isSuccess);

        List<ScheduleTask> tasks = scheduleTaskRepository.findAll();
        if (tasks.size() >= 10) {
            scheduleTaskRepository.delete(tasks.get(0));
        }
        scheduleTaskRepository.save(scheduleTask);
    }
}
