package com.mangkyu.currency.exchanger.app.exchange.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

@Getter
public class ExchangeException extends CommonException {

    public ExchangeException(final LogLevel logLevel, final ExchangeErrorCode errorCode) {
        super(logLevel, errorCode);
    }

}