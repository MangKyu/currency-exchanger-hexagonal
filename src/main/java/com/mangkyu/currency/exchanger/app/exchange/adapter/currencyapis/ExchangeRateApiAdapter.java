package com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchange.application.converter.ExchangeConverter;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRateApiAdapter implements LoadExchangeRatePort {

    private final CurrentExchangeRateCaller exchangeRateCaller;

    @Override
    public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
        final CurrentExchangeRateResponse response = exchangeRateCaller.call(source, target);
        return ExchangeConverter.INSTANCE.toExchangeRate(response, target);
    }

}
