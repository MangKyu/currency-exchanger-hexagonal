package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeMoneyUseCase;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements ExchangeMoneyUseCase {

    private final GetExchangeRateUseCase getExchangeRateUseCase;

    @Override
    public Money exchangeMoney(final Money money, final Currency target) {
        final double exchangeRate = getExchangeRateUseCase.getExchangeRate(target);

        return money.exchange(exchangeRate, target);
    }

}
