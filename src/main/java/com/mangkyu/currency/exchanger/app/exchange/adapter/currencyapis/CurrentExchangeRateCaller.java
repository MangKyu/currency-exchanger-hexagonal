package com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;

@FunctionalInterface
public interface CurrentExchangeRateCaller {

    CurrentExchangeRateResponse call(final Currency source, final Currency target);

}
