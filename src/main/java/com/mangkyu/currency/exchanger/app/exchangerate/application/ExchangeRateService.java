package com.mangkyu.currency.exchanger.app.exchangerate.application;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRateService implements GetExchangeRateUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;

    @Override
    public double getExchangeRate(final Currency target) {
        if (!Currency.canBeTarget(target)) {
            throw new ExchangeRateException(ExchangeRateErrorCode.INVALID_TARGET_CURRENCY);
        }

        return loadExchangeRatePort.getExchangeRate(Currency.USD, target)
                .getPrice();
    }

}
