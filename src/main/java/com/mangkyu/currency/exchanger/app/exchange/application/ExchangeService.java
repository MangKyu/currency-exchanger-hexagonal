package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements GetExchangeRateUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;

    @Override
    public double getExchangeRate(final Currency target) {
        if (!Currency.canBeTarget(target)) {
            throw new ExchangeException(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
        }

        return loadExchangeRatePort.getExchangeRate(Currency.USD, target)
                .getPrice();
    }

}
