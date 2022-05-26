package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.application.ExchangeService;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;

    @BeforeEach
    void init() {
        target = new ExchangeService(new TestLoadExchangePort());
    }

    @ParameterizedTest
    @EnumSource(
            value = Currency.class,
            names = {"USD"},
            mode = EnumSource.Mode.INCLUDE)
    void 환율정보조회실패_잘못된파라미터(final Currency param) {

        final ExchangeException result = assertThrows(ExchangeException.class, () -> target.getExchangeRate(param));
        assertThat(result.getErrorCode()).isEqualTo(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
    }

    @Test
    void 환율조회성공() {
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