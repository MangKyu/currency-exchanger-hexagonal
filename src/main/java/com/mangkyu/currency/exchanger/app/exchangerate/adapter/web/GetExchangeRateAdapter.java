package com.mangkyu.currency.exchanger.app.exchangerate.adapter.web;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class GetExchangeRateAdapter {

    private final GetExchangeRateUseCase getExchangeRateUseCase;

    @GetMapping("/api/exchange-rates")
    public ResponseEntity<GetExchangeRateResponse> getExchangeRate(final Currency source, final Currency target) {
        final double exchangeRate = getExchangeRateUseCase.getExchangeRate(source, target);

        final GetExchangeRateResponse response = new GetExchangeRateResponse(
                String.format("%.2f", exchangeRate),
                source.toExchangeUnit(target));

        return ResponseEntity.ok(response);
    }

}
