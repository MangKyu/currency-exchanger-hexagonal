package com.mangkyu.currency.exchanger.app.exchange.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;

public interface LoadExchangeRatePort {

    ExchangeRate getExchangeRate(final Currency source, final Currency target);

}
