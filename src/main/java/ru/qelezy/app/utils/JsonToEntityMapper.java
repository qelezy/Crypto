package ru.qelezy.app.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.qelezy.app.entities.Coin;

import java.util.ArrayList;
import java.util.List;

public class JsonToEntityMapper {
    public static final Logger logger = LoggerFactory.getLogger(JsonToEntityMapper.class);
    public static List<Coin> mapJsonToEntity(String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        List<Coin> coins = new ArrayList<>();
        try {
            JsonNode root = mapper.readTree(jsonData);
            JsonNode dataArray = root.path("data");

            for (JsonNode node : dataArray) {
                Coin coin = new Coin();

                coin.setCoinName(node.path("name").asText());
                coin.setCoinCode(node.path("symbol").asText());
                coin.setPrice(node.path("price_usd").asDouble());
                coin.setOneHourChange(node.path("percent_change_1h").asDouble());
                coin.setTwentyFourHoursChange(node.path("percent_change_24h").asDouble());
                coin.setSevenDaysChange(node.path("percent_change_7d").asDouble());
                coin.setMarketCap(node.path("market_cap_usd").asDouble());
                coin.setVolume(node.path("volume24").asDouble());

                coins.add(coin);
            }
        } catch (Exception exception) {
            logger.error("Не удалось считать JSON\n", exception);
        }
        return coins;
    }
}
