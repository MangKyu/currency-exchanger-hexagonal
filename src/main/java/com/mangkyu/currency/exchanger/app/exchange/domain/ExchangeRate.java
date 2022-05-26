package com.mangkyu.currency.exchanger.app.exchange.domain;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ExchangeRate {

    private final Currency source;
    private final Currency target;
    private final ExchangePrice price;

    public double getPrice() {
        return price.getPrice();
    }

}
