package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;


import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class AddExchangeRateHistoryRequest {

    private final Currency source;
    private final Currency target;
    private final Double price;

}
