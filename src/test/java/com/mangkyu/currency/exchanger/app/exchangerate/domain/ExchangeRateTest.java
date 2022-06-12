package com.mangkyu.currency.exchanger.app.exchangerate.domain;

import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.sourceCurrency;
import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.targetCurrency;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateTest {

    @Test
    void 데시말포맷으로변환() {

        final ExchangeRate exchangeRate = new ExchangeRate(
                sourceCurrency,
                targetCurrency,
                new ExchangePrice(112_1.419945));

        final String result = exchangeRate.toFormattedRate();

        assertThat(result).isEqualTo("1,121.42");
    }

}