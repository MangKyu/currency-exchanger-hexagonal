package com.mangkyu.currency.exchanger.app.common.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.logging.LogLevel;

@Getter
@RequiredArgsConstructor
public class CommonException extends RuntimeException {

    private final LogLevel logLevel;
    private final ErrorCode errorCode;

}