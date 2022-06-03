package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_history")
@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExchangeHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency source;

    @Enumerated(EnumType.STRING)
    private Currency target;

    private Double rate;

    private Long amount;

    @CreationTimestamp
    @Column(nullable = false, length = 20, updatable = false)
    private LocalDateTime createdAt;

}
