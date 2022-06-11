package com.mangkyu.currency.exchanger.app.exchangerate.domain;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.text.DecimalFormat;

@Getter
@Builder
@RequiredArgsConstructor
//@NoArgsConstructor(force = true)
public class ExchangeRate {

    private final Currency source;
    private final Currency target;
    private final ExchangePrice price;

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.00");

    public double getPrice() {
        return price.getPrice();
    }

    public String toFormattedRate() {
        return DECIMAL_FORMAT.format(price);
    }

}
