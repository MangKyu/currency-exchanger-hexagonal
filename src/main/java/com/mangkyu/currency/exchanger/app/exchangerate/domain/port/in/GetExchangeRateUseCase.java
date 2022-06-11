package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;

public interface GetExchangeRateUseCase {

    ExchangeRate getExchangeRate(final Currency source, final Currency target);

}
