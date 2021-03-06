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

    INVALID_TARGET_CURRENCY(HttpStatus.BAD_REQUEST, "Target currency is invalid."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}