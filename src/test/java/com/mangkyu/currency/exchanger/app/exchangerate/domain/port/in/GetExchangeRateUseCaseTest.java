package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.application.ExchangeRateService;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateHistoryQuery;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateQuery;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.SaveExchangeRateHistoryCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GetExchangeRateUseCaseTest {

    private GetExchangeRateUseCase target;
    private LoadExchangeRateQuery loadExchangeRateQuery;
    private SaveExchangeRateHistoryCommand saveExchangeRateHistoryCommand;
    private LoadExchangeRateHistoryQuery loadExchangeRateHistoryQuery;

    @BeforeEach
    void init() {
        loadExchangeRateQuery = mock(LoadExchangeRateQuery.class);
        saveExchangeRateHistoryCommand = mock(SaveExchangeRateHistoryCommand.class);
        loadExchangeRateHistoryQuery = mock(LoadExchangeRateHistoryQuery.class);
        target = new ExchangeRateService(loadExchangeRateQuery, saveExchangeRateHistoryCommand, loadExchangeRateHistoryQuery);
    }

    @Test
    void 현재환율조회성공() {
        doReturn(Optional.of(exchangeRate)).when(loadExchangeRateQuery)
                .loadExchangeRate(sourceCurrency, targetCurrency);

        final ExchangeRate result = target.getExchangeRate(sourceCurrency, targetCurrency);

        assertThat(result.getPrice()).isEqualTo(price);

        verify(loadExchangeRateQuery, times(1)).loadExchangeRate(sourceCurrency, targetCurrency);
        verify(saveExchangeRateHistoryCommand, times(1)).save(any(AddExchangeRateHistoryRequest.class));
    }

    @Test
    void 최근값으로_환율조회성공() {
        doReturn(Optional.empty()).when(loadExchangeRateQuery)
                .loadExchangeRate(sourceCurrency, targetCurrency);
        doReturn(exchangeRate).when(loadExchangeRateHistoryQuery)
                .loadLatest(sourceCurrency, targetCurrency);

        final ExchangeRate result = target.getExchangeRate(sourceCurrency, targetCurrency);

        assertThat(result.getPrice()).isEqualTo(price);

        verify(loadExchangeRateQuery, times(1)).loadExchangeRate(sourceCurrency, targetCurrency);
        verify(saveExchangeRateHistoryCommand, times(0)).save(any(AddExchangeRateHistoryRequest.class));
        verify(loadExchangeRateHistoryQuery, times(1)).loadLatest(sourceCurrency, targetCurrency);
    }

}