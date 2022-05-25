package com.mangkyu.currency.exchanger.app.exchange.domain;

import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {

    @Test
    void quoteKey생성() {
        final String result = sourceCurrency.quoteKey(targetCurrency);
        assertThat(result).isEqualTo(quoteKey);
    }

}
