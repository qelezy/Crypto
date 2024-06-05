package ru.qelezy.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="portfolio_coin",
            joinColumns=  @JoinColumn(name="portfolio_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name="coin_id", referencedColumnName = "id"))
    private List<Coin> coins;

    @OneToMany
    @JoinColumn(name = "portfolio_id", nullable = true)
    private List<Deal> deals;

    @Column(name = "profile_volume_USD")
    private List<Double> profileVolumeUSD;

    @Column(name = "profile_volume_BTC")
    private List<Double> profileVolumeBTC;

    @Column(name = "current_volume_USD")
    private Double currentVolumeUSD;

    @Column(name = "current_volume_BTC")
    private Double currentVolumeBTC;
}
