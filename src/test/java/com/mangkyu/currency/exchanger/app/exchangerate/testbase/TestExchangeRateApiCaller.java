package com.mangkyu.currency.exchanger.app.exchangerate.testbase;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateCaller;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;

import java.util.Collections;
import java.util.Map;

public class TestExchangeRateApiCaller implements CurrentExchangeRateCaller {

    private Map<String, Double> quotes = Collections.emptyMap();

    public void setQuotes(final Map<String, Double> quotes) {
        this.quotes = quotes;
    }

    @Override
    public CurrentExchangeRateResponse call(final Currency source, final Currency target) {
        return CurrentExchangeRateResponse.builder()
                .timestamp(System.currentTimeMillis())
                .source(source)
                .quotes(quotes)
                .build();
    }

}