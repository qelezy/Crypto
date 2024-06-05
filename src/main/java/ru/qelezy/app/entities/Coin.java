package ru.qelezy.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "coin_code")
    private String coinCode;

    private Double price;

    @Column(name = "1h")
    private Double oneHourChange;

    @Column(name = "24h")
    private Double twentyFourHoursChange;

    @Column(name = "7d")
    private Double sevenDaysChange;

    @Column(name = "market_cap")
    private Double marketCap;

    private Double volume;

    @Column(name = "last_price")
    private List<Double> lastPrice;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "portfolio_coin",
            joinColumns =  @JoinColumn(name="coin_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="portfolio_id", referencedColumnName = "id"))
    private Set<Portfolio> portfolios = new HashSet<Portfolio>();
}
