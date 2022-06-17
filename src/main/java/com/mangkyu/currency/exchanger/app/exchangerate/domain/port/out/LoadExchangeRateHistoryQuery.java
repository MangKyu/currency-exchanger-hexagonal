package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;

public interface LoadExchangeRateHistoryQuery {
    ExchangeRate loadLatest(final Currency source, final Currency target);
}
