package ru.qelezy.app.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Deal {
    String date;
    String type;
    Double price;
    Double volume;
    String coinName;
    String coinCode;
}
