package ru.qelezy.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "exchanges")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double score;

    @Column(name = "volume_24h")
    private Double volumeTwentyFourHours;
    private Double markets;
    private Double coins;

    @Column(name = "last_volume")
    private List<Double> lastVolume;
}
