package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;

@FunctionalInterface
public interface CurrentExchangeRateCaller {

    CurrentExchangeRateResponse call(final Currency source, final Currency target);

}
