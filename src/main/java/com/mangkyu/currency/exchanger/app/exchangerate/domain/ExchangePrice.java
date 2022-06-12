package com.mangkyu.currency.exchanger.app.exchangerate.domain;

import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

@Getter
public class ExchangePrice {

    private final Double price;

    public ExchangePrice(final Double price) {
        if (price <= 0) {
            throw new ExchangeRateException(LogLevel.WARN, ExchangeRateErrorCode.FETCH_EXCHANGE_RATE_FAIL);
        }

        this.price = price;
    }
}
