package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;

public interface ExchangeMoneyUseCase {

    Money exchangeMoney(final Money money, final Currency target);
}
