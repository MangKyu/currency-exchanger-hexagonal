package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;

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
            throw new ExchangeRateException(LogLevel.WARN, ExchangeRateErrorCode.FETCH_EXCHANGE_RATE_FAIL);
        }

        return quotes.get(key);
    }

}
