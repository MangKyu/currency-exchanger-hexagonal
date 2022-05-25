package com.mangkyu.currency.exchanger.app.exchange.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import com.mangkyu.currency.exchanger.app.common.errors.ErrorCode;
import lombok.Getter;

@Getter
public class ExchangeException extends CommonException {

    public ExchangeException(final ErrorCode errorCode) {
        super(errorCode);
    }

}