package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.converter.ExchangeConverter;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeUseCase;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.SaveExchangeHistoryPort;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements ExchangeUseCase {

    private final GetExchangeRateUseCase getExchangeRateUseCase;
    private final SaveExchangeHistoryPort saveExchangeHistoryPort;

    @Override
    public Money exchangeMoney(final Money money, final Currency target) {
        if (!Currency.canBeTarget(target)) {
            throw new ExchangeException(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
        }

        final double exchangeRate = getExchangeRateUseCase.getExchangeRate(money.getCurrency(), target);
        final Money exchangedMoney = money.exchange(exchangeRate, target);

        saveExchangeHistoryPort.add(ExchangeConverter.INSTANCE.toAddExchangeHistoryRequest(money, target, exchangeRate));

        return exchangedMoney;
    }

}
