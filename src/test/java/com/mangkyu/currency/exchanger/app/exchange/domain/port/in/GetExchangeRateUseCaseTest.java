package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.application.ExchangeService;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;

    @BeforeEach
    void init() {
        target = new ExchangeService(new TestLoadExchangePort());
    }

    @Test
    void 환율조회() {
        final double result = target.getExchangeRate(targetCurrency);

        assertThat(result).isEqualTo(price);
    }

    private static class TestLoadExchangePort implements LoadExchangeRatePort {

        @Override
        public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
            return exchangeRate;
        }

    }

}