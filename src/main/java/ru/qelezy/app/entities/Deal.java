package ru.qelezy.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deals")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String date;
    private String type;
    private Double price;
    private Double volume;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "coin_code")
    private String coinCode;
}
