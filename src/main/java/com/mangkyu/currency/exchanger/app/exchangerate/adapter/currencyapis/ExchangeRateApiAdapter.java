package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ExchangeRateApiAdapter implements LoadExchangeRatePort {

    private final CurrentExchangeRateCaller exchangeRateCaller;

    @Override
    public Optional<ExchangeRate> getExchangeRate(final Currency source, final Currency target) {
        try {
            final CurrentExchangeRateResponse response = exchangeRateCaller.call(source, target);
            return Optional.of(ExchangeRateConverter.INSTANCE.toExchangeRate(response, target));

        } catch (final ExchangeRateException e) {
            log.warn("GetExchangeRate Fail, source={}, target={}", source, target, e);
        }
        return Optional.empty();
    }

}
