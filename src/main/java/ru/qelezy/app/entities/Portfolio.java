package ru.qelezy.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Portfolio {
    List<Coin> coins;
    List<Deal> deals;
    List<Double> profileVolumeUSD;
    List<Double> profileVolumeBTC;
    Double currentVolumeUSD;
    Double currentVolumeBTC;
}
