package com.mangkyu.currency.exchanger.app.exchange.testbase;

import com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;

import java.util.Collections;

public final class ExchangeTestBase {

    private ExchangeTestBase() {

    }

    public static final Currency sourceCurrency = Currency.USD;
    public static final Currency targetCurrency = Currency.KRW;
    public static final String quoteKey = "USDKRW";
    public static final double rate = 112_1.419945;

    public static CurrentExchangeRateResponse exchangeRateResponse = CurrentExchangeRateResponse.builder()
            .timestamp(System.currentTimeMillis())
            .source(sourceCurrency)
            .quotes(Collections.singletonMap(quoteKey, rate))
            .build();

}
