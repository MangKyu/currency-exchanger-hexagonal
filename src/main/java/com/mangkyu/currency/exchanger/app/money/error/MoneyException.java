package com.mangkyu.currency.exchanger.app.money.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

@Getter
public class MoneyException extends CommonException {

    public MoneyException(final LogLevel logLevel, final MoneyErrorCode errorCode) {
        super(logLevel, errorCode);
    }

}