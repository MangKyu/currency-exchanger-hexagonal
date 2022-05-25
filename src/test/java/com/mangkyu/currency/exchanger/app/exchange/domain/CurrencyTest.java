package com.mangkyu.currency.exchanger.app.exchange.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {

    @Test
    void quoteKey생성() {
        final String result = sourceCurrency.quoteKey(targetCurrency);
        assertThat(result).isEqualTo(quoteKey);
    }

    @ParameterizedTest
    @EnumSource(
            value = Currency.class,
            names = {"USD"},
            mode = EnumSource.Mode.EXCLUDE)
    void target이될수있음(final Currency target) {
        final boolean result = Currency.canBeTarget(target);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @EnumSource(
            value = Currency.class,
            names = {"USD"},
            mode = EnumSource.Mode.INCLUDE)
    void target이될수없음(final Currency target) {
        final boolean result = Currency.canBeTarget(target);
        assertThat(result).isFalse();
    }


    @Test
    void Null도target이될수없음() {
        final boolean result = Currency.canBeTarget(null);
        assertThat(result).isFalse();
    }

}
