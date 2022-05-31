package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRateApiAdapter implements LoadExchangeRatePort {

    private final CurrentExchangeRateCaller exchangeRateCaller;

    @Override
    public ExchangeRate getExchangeRate(final Currency source, final Currency target) {
        final CurrentExchangeRateResponse response = exchangeRateCaller.call(source, target);
        return ExchangeRateConverter.INSTANCE.toExchangeRate(response, target);
    }

}
