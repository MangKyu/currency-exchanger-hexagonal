package com.mangkyu.currency.exchanger.app.exchangerate.converter;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangeRateConverterTest {

    @Test
    void ExchangeRate로변환() {
        final ExchangeRate result = ExchangeRateConverter.INSTANCE.toExchangeRate(exchangeRateResponse, targetCurrency);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(sourceCurrency);
        assertThat(result.getTarget()).isEqualTo(targetCurrency);
        assertThat(result.getPrice()).isEqualTo(price);
    }

}