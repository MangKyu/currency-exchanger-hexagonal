package com.mangkyu.currency.exchanger.app.exchangerate.application;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.SaveExchangeRateHistoryPort;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService implements GetExchangeRateUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;
    private final SaveExchangeRateHistoryPort exchangeRateHistoryPort;

    @Override
    public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
        final ExchangeRate exchangeRate = loadExchangeRatePort.getExchangeRate(source, target);

        exchangeRateHistoryPort.save(ExchangeRateConverter.INSTANCE.toAddExchangeRateHistoryRequest(exchangeRate));

        return exchangeRate;
    }

}
