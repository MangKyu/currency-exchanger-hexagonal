package com.mangkyu.currency.exchanger.app.exchangerate.application;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateHistoryQuery;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateQuery;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.SaveExchangeRateHistoryCommand;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService implements GetExchangeRateUseCase {

    private final LoadExchangeRateQuery loadExchangeRateQuery;
    private final SaveExchangeRateHistoryCommand saveExchangeRateHistoryCommand;
    private final LoadExchangeRateHistoryQuery loadExchangeRateHistoryQuery;

    @Override
    public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
        final Optional<ExchangeRate> optionalExchangeRate = loadExchangeRateQuery.loadExchangeRate(source, target);
        optionalExchangeRate.ifPresent(v -> saveExchangeRateHistoryCommand.save(ExchangeRateConverter.INSTANCE.toAddExchangeRateHistoryRequest(v)));

        return optionalExchangeRate.orElseGet(() -> loadExchangeRateHistoryQuery.loadLatest(source, target));
    }

}
