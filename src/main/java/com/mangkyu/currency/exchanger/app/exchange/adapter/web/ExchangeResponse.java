package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
class ExchangeResponse {

    private final Long amount;
    private final Currency currency;

}
