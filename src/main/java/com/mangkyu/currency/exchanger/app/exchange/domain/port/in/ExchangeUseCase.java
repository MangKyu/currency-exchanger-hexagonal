package com.mangkyu.currency.exchanger.app.exchange.domain.port.in;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;

public interface ExchangeUseCase {

    Money exchangeMoney(final Money money, final Currency target);
}
