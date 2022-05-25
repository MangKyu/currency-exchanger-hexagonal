package com.mangkyu.currency.exchanger.app.exchange.testbase;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;

public final class ExchangeTestBase {

    private ExchangeTestBase() {

    }

    public static final Currency sourceCurrency = Currency.USD;
    public static final Currency targetCurrency = Currency.KRW;
    public static final double rate = 112_1.419945;

}
