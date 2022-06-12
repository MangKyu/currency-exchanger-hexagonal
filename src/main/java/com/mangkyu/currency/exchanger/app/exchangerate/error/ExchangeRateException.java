package com.mangkyu.currency.exchanger.app.exchangerate.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

@Getter
public class ExchangeRateException extends CommonException {

    public ExchangeRateException(final LogLevel logLevel, final ExchangeRateErrorCode errorCode) {
        super(logLevel, errorCode);
    }

}