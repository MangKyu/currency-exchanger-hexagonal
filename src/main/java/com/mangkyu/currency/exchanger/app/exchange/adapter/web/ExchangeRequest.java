package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
class ExchangeRequest {

    @Positive
    private final Long amount;

    @NotNull
    private final Currency sourceCurrency;

    @NotNull
    private final Currency targetCurrency;

}
