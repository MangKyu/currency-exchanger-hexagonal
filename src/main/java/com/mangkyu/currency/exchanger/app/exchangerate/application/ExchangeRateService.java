package com.mangkyu.currency.exchanger.app.exchangerate.application;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService implements GetExchangeRateUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;

    @Override
    public double getExchangeRate(final Currency source, final Currency target) {
        return loadExchangeRatePort.getExchangeRate(source, target)
                .getPrice();
    }

}
