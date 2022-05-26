package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.application.ExchangeService;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ExchangeMoneyUseCaseTest {

    private ExchangeMoneyUseCase target;
    private LoadExchangeRatePort loadExchangeRatePort;

    @BeforeEach
    void init() {
        loadExchangeRatePort = mock(LoadExchangeRatePort.class);
        target = new ExchangeService(loadExchangeRatePort);
    }

    @Test
    void 환전성공() {
        doReturn(exchangeRate)
                .when(loadExchangeRatePort)
                .getExchangeRate(Currency.USD, targetCurrency);

        final Money result = target.exchangeMoney(money, targetCurrency);
        assertThat(result).isEqualTo(exchangedMoney);
    }

}