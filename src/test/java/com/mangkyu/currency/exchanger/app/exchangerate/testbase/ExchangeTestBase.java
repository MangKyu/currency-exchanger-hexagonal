package com.mangkyu.currency.exchanger.app.exchangerate.testbase;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangePrice;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Money;

import java.util.Collections;

public final class ExchangeTestBase {

    private ExchangeTestBase() {

    }

    public static final Currency sourceCurrency = Currency.USD;
    public static final Currency targetCurrency = Currency.KRW;
    public static final String quoteKey = "USDKRW";
    public static final double price = 112_1.419945;
    public static final double roundedPrice = 112_1.42;

    public static final long amount = 100L;
    public static final Money money = Money.of(amount, sourceCurrency);
    public static final Money exchangedMoney = Money.of(112_141, targetCurrency);
    public static final String exchangeUnit = sourceCurrency.toExchangeUnit(targetCurrency);

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
