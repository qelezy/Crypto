package ru.qelezy.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Coin {
    String coinName;
    String coinCode;
    Double price;
    Double oneHourChange;
    Double twentyFourHoursChange;
    Double sevenDaysChange;
    Double marketCap;
    Double volume;
    List<Double> lastPrice;
}
