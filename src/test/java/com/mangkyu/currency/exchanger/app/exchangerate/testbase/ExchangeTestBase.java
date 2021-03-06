package com.mangkyu.currency.exchanger.app.exchangerate.testbase;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangePrice;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;

import java.util.Collections;

public final class ExchangeTestBase {

    private ExchangeTestBase() {

    }

    public static final Currency sourceCurrency = Currency.USD;
    public static final Currency targetCurrency = Currency.KRW;
    public static final String quoteKey = "USDKRW";
    public static final double price = 112_1.419945;
    public static final String formattedPrice = "1,121.42";

    public static final long amount = 100L;
    public static final Money money = new Money(amount, sourceCurrency);
    public static final Money exchangedMoney = new Money(112_141, targetCurrency);
    public static final String formattedExchangedMoneyAmount = "112,141.00";
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

    public static AddExchangeHistoryRequest addExchangeHistoryRequest = AddExchangeHistoryRequest.builder()
            .source(sourceCurrency)
            .target(targetCurrency)
            .rate(price)
            .amount(amount)
            .build();

    public static AddExchangeRateHistoryRequest addExchangeRateHistoryRequest = AddExchangeRateHistoryRequest.builder()
            .source(sourceCurrency)
            .target(targetCurrency)
            .price(price)
            .build();
}
