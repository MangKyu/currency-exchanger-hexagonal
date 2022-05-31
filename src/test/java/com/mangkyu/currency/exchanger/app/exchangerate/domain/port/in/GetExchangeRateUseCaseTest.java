package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchangerate.application.ExchangeRateService;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;

    @BeforeEach
    void init() {
        target = new ExchangeRateService(new TestLoadExchangePort());
    }

    @Test
    void 환율조회성공() {
        final double result = target.getExchangeRate(sourceCurrency, targetCurrency);

        assertThat(result).isEqualTo(price);
    }

    private static class TestLoadExchangePort implements LoadExchangeRatePort {

        @Override
        public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
            return exchangeRate;
        }

    }

}