package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements GetExchangeRateUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;

    @Override
    public double getExchangeRate(final Currency target) {
        return loadExchangeRatePort.getExchangeRate(Currency.USD, target)
                .getPrice();
    }

}
