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

    @GetMapping("/exchange-rates")
    public ResponseEntity<Map<String, Double>> getExchangeRate(final Currency target) {
        if (target == null) {
            throw new ExchangeException(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
        }
        return ResponseEntity.ok(Collections.singletonMap("rate", getExchangeRateUseCase.getExchangeRate(target)));
    }

}
