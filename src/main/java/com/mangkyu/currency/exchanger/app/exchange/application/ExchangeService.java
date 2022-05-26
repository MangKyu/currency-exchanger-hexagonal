package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeMoneyUseCase;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.LoadExchangeRatePort;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements GetExchangeRateUseCase, ExchangeMoneyUseCase {

    private final LoadExchangeRatePort loadExchangeRatePort;

    @Override
    public double getExchangeRate(final Currency target) {
        if (!Currency.canBeTarget(target)) {
            throw new ExchangeException(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
        }

        return loadExchangeRatePort.getExchangeRate(Currency.USD, target)
                .getPrice();
    }

    @Override
    public Money exchangeMoney(final Money money, final Currency target) {
        final double exchangeRate = getExchangeRate(target);

        return money.exchange(exchangeRate, target);
    }
}
