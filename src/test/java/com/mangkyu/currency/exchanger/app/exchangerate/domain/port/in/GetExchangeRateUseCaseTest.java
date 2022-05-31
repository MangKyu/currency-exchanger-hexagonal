package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchangerate.application.ExchangeRateService;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;

    @BeforeEach
    void init() {
        target = new ExchangeRateService(new TestLoadExchangePort());
    }

    @ParameterizedTest
    @EnumSource(
            value = Currency.class,
            names = {"USD"},
            mode = EnumSource.Mode.INCLUDE)
    void 환율정보조회실패_잘못된파라미터(final Currency param) {

        final ExchangeRateException result = assertThrows(ExchangeRateException.class, () -> target.getExchangeRate(param));
        assertThat(result.getErrorCode()).isEqualTo(ExchangeRateErrorCode.INVALID_TARGET_CURRENCY);
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