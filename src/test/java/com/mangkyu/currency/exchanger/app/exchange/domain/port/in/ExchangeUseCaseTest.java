package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.application.ExchangeService;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.SaveExchangeHistoryCommand;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ExchangeUseCaseTest {

    private ExchangeUseCase target;
    private GetExchangeRateUseCase getExchangeRateUseCase;
    private SaveExchangeHistoryCommand saveExchangeHistoryCommand;

    @BeforeEach
    void init() {
        getExchangeRateUseCase = mock(GetExchangeRateUseCase.class);
        saveExchangeHistoryCommand = mock(SaveExchangeHistoryCommand.class);
        target = new ExchangeService(getExchangeRateUseCase, saveExchangeHistoryCommand);
    }

    @ParameterizedTest
    @EnumSource(
            value = Currency.class,
            names = {"USD"},
            mode = EnumSource.Mode.INCLUDE)
    void 환전실패_잘못된파라미터(final Currency param) {

        final ExchangeException result = assertThrows(ExchangeException.class, () -> target.exchangeMoney(money, param));
        assertThat(result.getErrorCode()).isEqualTo(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
    }

    @Test
    void 환전성공() {
        doReturn(exchangeRate)
                .when(getExchangeRateUseCase)
                .getExchangeRate(sourceCurrency, targetCurrency);

        final Money result = target.exchangeMoney(money, targetCurrency);
        assertThat(result).isEqualTo(exchangedMoney);

        verify(saveExchangeHistoryCommand, times(1)).save(any(AddExchangeHistoryRequest.class));
    }

}