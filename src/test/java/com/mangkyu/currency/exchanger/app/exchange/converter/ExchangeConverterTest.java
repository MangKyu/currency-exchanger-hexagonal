package com.mangkyu.currency.exchanger.app.exchange.converter;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryEntity;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class ExchangeConverterTest {

    @Test
    void ExchangeHistoryEntity로변환() {
        final ExchangeHistoryEntity result = ExchangeConverter.INSTANCE.toExchangeHistoryEntity(addExchangeHistoryRequest);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(addExchangeHistoryRequest.getSource());
        assertThat(result.getTarget()).isEqualTo(addExchangeHistoryRequest.getTarget());
        assertThat(result.getRate()).isEqualTo(addExchangeHistoryRequest.getRate());
        assertThat(result.getAmount()).isEqualTo(addExchangeHistoryRequest.getAmount());
    }

    @Test
    void AddExchangeHistoryRequest로변환() {
        final AddExchangeHistoryRequest result = ExchangeConverter.INSTANCE.toAddExchangeHistoryRequest(money, targetCurrency, price);

        assertThat(result).isNotNull();
        assertThat(result.getSource()).isEqualTo(money.getCurrency());
        assertThat(result.getTarget()).isEqualTo(targetCurrency);
        assertThat(result.getRate()).isEqualTo(price);
        assertThat(result.getAmount()).isEqualTo(money.toLong());
    }

}