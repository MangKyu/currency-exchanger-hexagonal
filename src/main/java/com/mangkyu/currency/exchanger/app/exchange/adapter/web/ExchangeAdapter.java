package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.DecimalFormat;

@RestController
@RequiredArgsConstructor
@Slf4j
class ExchangeAdapter {

    private final ExchangeUseCase exchangeUseCase;

    @PostMapping("/api/exchange")
    public ResponseEntity<ExchangeResponse> exchange(@RequestBody @Valid final ExchangeRequest exchangeRequest) {
        final Money exchangedMoney = exchangeUseCase.exchangeMoney(
                Money.of(exchangeRequest.getAmount(), Currency.USD),
                exchangeRequest.getTargetCurrency());

        return ResponseEntity.ok(new ExchangeResponse(
                new DecimalFormat("#,###.00").format(exchangedMoney.toLong()),
                exchangedMoney.getCurrency()));
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleBaseException(final MethodArgumentNotValidException e) {
//        final String errorMessage = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).findFirst().orElse(CommonErrorCode.INVALID_PARAMETER.getMessage());
//        return ResponseEntity.ok("ad");
//    }

}
