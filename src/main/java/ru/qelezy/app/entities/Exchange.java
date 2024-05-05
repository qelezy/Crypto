package ru.qelezy.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Exchange {
    String name;
    Double score;
    Double volumeTwentyFourHours;
    Double markets;
    Double coins;
    List<Double> lastVolume;
}
