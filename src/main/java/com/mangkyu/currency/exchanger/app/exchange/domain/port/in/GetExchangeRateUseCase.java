package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;

public interface GetExchangeRateUseCase {

    double getExchangeRate(final Currency target);

}
