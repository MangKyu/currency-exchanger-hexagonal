package com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
class CurrentExchangeRateResponse {

    private final long timestamp;
    private final Currency source;
    private final Map<String, Double> quotes;

}
