package com.mangkyu.currency.exchanger.app.money.error;

import com.mangkyu.currency.exchanger.app.common.errors.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@ToString
public enum MoneyErrorCode implements ErrorCode {

    INVALID_AMOUNT(HttpStatus.BAD_REQUEST, "Amount is invalid."),
    ;

    private final HttpStatus httpStatus;
    private final String message;

}