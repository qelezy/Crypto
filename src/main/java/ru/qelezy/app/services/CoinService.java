package ru.qelezy.app.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qelezy.app.entities.Coin;
import ru.qelezy.app.repositories.CoinRepository;

import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    @Transactional
    public void saveOrUpdateCoins(List<Coin> coins) {
        for (Coin coin : coins) {
            Coin existingCoin = coinRepository.findByCoinCode(coin.getCoinCode());
            if (existingCoin != null) {
                existingCoin.setCoinName(coin.getCoinName());
                existingCoin.setCoinCode(coin.getCoinCode());
                existingCoin.setOneHourChange(coin.getOneHourChange());
                existingCoin.setTwentyFourHoursChange(coin.getTwentyFourHoursChange());
                existingCoin.setSevenDaysChange(coin.getSevenDaysChange());
                existingCoin.setMarketCap(coin.getMarketCap());
                existingCoin.setVolume(coin.getVolume());
                coinRepository.save(existingCoin);
            } else {
                coinRepository.save(coin);
            }
        }
    }
}
