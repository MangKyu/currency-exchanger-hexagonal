package com.mangkyu.currency.exchanger.app.exchange.testbase;

import com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangePrice;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;

import java.util.Collections;

public final class ExchangeTestBase {

    private ExchangeTestBase() {

    }

    public static final Currency sourceCurrency = Currency.USD;
    public static final Currency targetCurrency = Currency.KRW;
    public static final String quoteKey = "USDKRW";
    public static final double price = 112_1.419945;
    public static final double roundedPrice = 112_1.42;

    public static CurrentExchangeRateResponse exchangeRateResponse = CurrentExchangeRateResponse.builder()
            .timestamp(System.currentTimeMillis())
            .source(sourceCurrency)
            .quotes(Collections.singletonMap(quoteKey, price))
            .build();

    public static ExchangeRate exchangeRate = ExchangeRate.builder()
            .source(sourceCurrency)
            .target(targetCurrency)
            .price(new ExchangePrice(price))
            .build();

}
