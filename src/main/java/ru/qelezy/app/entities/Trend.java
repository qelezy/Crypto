package ru.qelezy.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trend {
    String coinName;
    String coinCode;
    Double twentyFourHoursChange;
}
