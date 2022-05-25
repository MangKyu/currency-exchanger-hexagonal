package com.mangkyu.currency.exchanger.app.exchange.application.converter;

import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangeConverterTest {

    @Test
    void ExchangeRate로변환() {
        final ExchangeRate result = ExchangeConverter.INSTANCE.toExchangeRate(exchangeRateResponse, targetCurrency);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(sourceCurrency);
        assertThat(result.getTarget()).isEqualTo(targetCurrency);
        assertThat(result.getPrice()).isEqualTo(price);
    }

}