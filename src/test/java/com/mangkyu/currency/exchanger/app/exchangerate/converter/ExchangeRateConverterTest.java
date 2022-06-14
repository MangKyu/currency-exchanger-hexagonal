package com.mangkyu.currency.exchanger.app.exchangerate.converter;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryEntity;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase;
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

    @Test
    void ExchangeRateHistoryEntitry로변환() {
        final AddExchangeRateHistoryRequest request = ExchangeTestBase.addExchangeRateHistoryRequest;
        final ExchangeRateHistoryEntity result = ExchangeRateConverter.INSTANCE.toExchangeRateHistoryEntity(request);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(request.getSource());
        assertThat(result.getTarget()).isEqualTo(request.getTarget());
        assertThat(result.getPrice()).isEqualTo(request.getPrice());
    }

    @Test
    void AddExchangeRateHistoryRequest로변환() {

        final ExchangeRate exchangeRate = ExchangeTestBase.exchangeRate;
        final AddExchangeRateHistoryRequest result = ExchangeRateConverter.INSTANCE.toAddExchangeRateHistoryRequest(exchangeRate);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(exchangeRate.getSource());
        assertThat(result.getTarget()).isEqualTo(exchangeRate.getTarget());
        assertThat(result.getPrice()).isEqualTo(exchangeRate.getPrice());
    }
}