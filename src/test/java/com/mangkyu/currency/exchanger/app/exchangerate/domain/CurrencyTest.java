package com.mangkyu.currency.exchanger.app.exchangerate.domain;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {

    @Test
    void 출력이름생성() {
        final String result = sourceCurrency.toViewString();
        assertThat(result).isEqualTo("미국(USD)");
    }

    @Test
    void 환전소스화폐조회() {
        final List<Currency> result = Currency.sourceCurrencies();
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void 환전대상화폐조회() {
        final List<Currency> result = Currency.targetCurrencies();
        assertThat(result.size()).isEqualTo(3);
    }

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
