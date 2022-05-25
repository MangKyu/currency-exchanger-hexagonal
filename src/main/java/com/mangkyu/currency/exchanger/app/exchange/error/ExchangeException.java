package com.mangkyu.currency.exchanger.app.exchange.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExchangeException extends RuntimeException {

    private final ExchangeErrorCode errorCode;

}