package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;

import java.util.Optional;

public interface LoadExchangeRatePort {

    Optional<ExchangeRate> getExchangeRate(final Currency source, final Currency target);

}
