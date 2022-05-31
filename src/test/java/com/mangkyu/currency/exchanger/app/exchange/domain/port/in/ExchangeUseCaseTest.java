package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.application.ExchangeService;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ExchangeUseCaseTest {

    private ExchangeMoneyUseCase target;
    private GetExchangeRateUseCase getExchangeRateUseCase;

    @BeforeEach
    void init() {
        getExchangeRateUseCase = mock(GetExchangeRateUseCase.class);
        target = new ExchangeService(getExchangeRateUseCase);
    }

    @Test
    void 환전성공() {
        doReturn(exchangeRate.getPrice())
                .when(getExchangeRateUseCase)
                .getExchangeRate(targetCurrency);

        final Money result = target.exchangeMoney(money, targetCurrency);
        assertThat(result).isEqualTo(exchangedMoney);
    }

}