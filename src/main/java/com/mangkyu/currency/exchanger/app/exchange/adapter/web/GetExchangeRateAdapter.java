package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
class GetExchangeRateAdapter {

    private final GetExchangeRateUseCase getExchangeRateUseCase;

    @GetMapping("/api/exchange-rates")
    public ResponseEntity<Map<String, String>> getExchangeRate(final Currency target) {
        final double rate = getExchangeRateUseCase.getExchangeRate(target);
        return ResponseEntity.ok(Collections.singletonMap("rate", String.format("%.2f", rate)));
    }

}
