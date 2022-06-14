package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.application.ExchangeRateService;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.SaveExchangeRateHistoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;
    private LoadExchangeRatePort loadExchangeRatePort;
    private SaveExchangeRateHistoryPort saveExchangeRateHistoryPort;

    @BeforeEach
    void init() {
        loadExchangeRatePort = mock(LoadExchangeRatePort.class);
        saveExchangeRateHistoryPort = mock(SaveExchangeRateHistoryPort.class);
        target = new ExchangeRateService(loadExchangeRatePort, saveExchangeRateHistoryPort);
    }

    @Test
    void 환율조회성공() {
        doReturn(exchangeRate).when(loadExchangeRatePort)
                .loadExchangeRate(sourceCurrency, targetCurrency);

        final ExchangeRate result = target.getExchangeRate(sourceCurrency, targetCurrency);

        assertThat(result.getPrice()).isEqualTo(price);

        verify(loadExchangeRatePort, times(1)).loadExchangeRate(sourceCurrency, targetCurrency);
        verify(saveExchangeRateHistoryPort, times(1)).save(any(AddExchangeRateHistoryRequest.class));
    }

}