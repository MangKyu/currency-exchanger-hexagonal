package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class AddExchangeHistoryRequest {

    private final Currency source;
    private final Currency target;
    private final double rate;
    private final long amount;

}
