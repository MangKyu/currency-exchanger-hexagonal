package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
class ExchangeRequest {

    public static final String INVALID_AMOUNT_MESSAGE = "송금액이 바르지 않습니다.";

    @Max(value = 10000, message = INVALID_AMOUNT_MESSAGE)
    @Positive(message = INVALID_AMOUNT_MESSAGE)
    private final Long amount;

    @NotNull
    private final Currency sourceCurrency;

    @NotNull
    private final Currency targetCurrency;

}
