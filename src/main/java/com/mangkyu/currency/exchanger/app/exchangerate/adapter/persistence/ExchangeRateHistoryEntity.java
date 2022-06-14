package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_rate_history")
@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExchangeRateHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency source;

    @Enumerated(EnumType.STRING)
    private Currency target;

    private Double price;

    @CreationTimestamp
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime createdAt;

}
