package com.mangkyu.currency.exchanger.app.exchange.domain;

import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import lombok.Getter;

@Getter
public class ExchangePrice {

    private final Double price;

    public ExchangePrice(final Double price) {
        if (price <= 0) {
            throw new ExchangeException(ExchangeErrorCode.FETCH_EXCHANGE_RATE_FAIL);
        }

        this.price = price;
    }
}
