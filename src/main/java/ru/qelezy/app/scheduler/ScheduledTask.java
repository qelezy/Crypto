package ru.qelezy.app.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.services.CoinService;
import ru.qelezy.app.services.ScheduleTaskService;
import ru.qelezy.app.utils.JsonToEntityMapper;

import java.util.List;

@Component
public class ScheduledTask {
    @Autowired
    private CoinService coinService;
    @Autowired
    private ScheduleTaskService scheduleTaskService;
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://api.coinlore.net/api/tickers/";

    @Scheduled(fixedRate = 60000) // Метод вызывается раз в минуту
    public void fetchFromAPI() {
        boolean isSuccess = false;

        try {
            String response = restTemplate.getForObject(URL, String.class);
            List<Coin> coins = JsonToEntityMapper.mapJsonToEntity(response);
            coinService.saveOrUpdateCoins(coins);
            isSuccess = true;
            logger.info("Удалось получить данные из API\n{}", response);
        } catch (Exception exception) {
            logger.error("Ошибка при получении данных из API\n", exception);
        }

        scheduleTaskService.saveScheduleTask(isSuccess);
    }
}
