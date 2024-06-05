package ru.qelezy.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trends")
public class Trend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trend_id")
    private List<Coin> coins;
}
