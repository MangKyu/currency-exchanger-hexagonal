package com.mangkyu.currency.exchanger.app.exchangerate.adapter.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
class GetExchangeRateResponse {

    private final String rate;
    private final String unit;

}
