package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;

public interface GetExchangeRateUseCase {

    double getExchangeRate(final Currency target);

}
