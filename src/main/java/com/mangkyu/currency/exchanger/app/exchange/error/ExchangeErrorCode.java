package com.mangkyu.currency.exchanger.app.exchange.error;

import com.mangkyu.currency.exchanger.app.common.errors.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@ToString
public enum ExchangeErrorCode implements ErrorCode {

    FETCH_EXCHANGE_RATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "Fetch exchange rate fail."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}