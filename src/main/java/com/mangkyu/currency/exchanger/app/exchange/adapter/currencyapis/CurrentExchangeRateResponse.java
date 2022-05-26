package com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class CurrentExchangeRateResponse {

    private final long timestamp;
    private final Currency source;
    private final Map<String, Double> quotes;

    public double getRate(final String key) {
        if (quotes == null || quotes.isEmpty()) {
            throw new ExchangeException(ExchangeErrorCode.FETCH_EXCHANGE_RATE_FAIL);
        }

        return quotes.get(key);
    }

}
