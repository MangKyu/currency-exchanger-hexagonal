package com.mangkyu.currency.exchanger.app.exchange.domain;

import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExchangePriceTest {

    @ParameterizedTest
    @ValueSource(doubles = {0, -0.0001, -100})
    void 잘못된환율가격(final double price) {
        final ExchangeException result = assertThrows(ExchangeException.class, () -> new ExchangePrice(price));

        assertThat(result.getErrorCode()).isEqualTo(ExchangeErrorCode.FETCH_EXCHANGE_RATE_FAIL);
    }

    @Test
    void 환율가격생성() {
        final double price = 0.0123;

        final ExchangePrice result = new ExchangePrice(price);

        assertThat(result.getPrice()).isEqualTo(price);
    }

}