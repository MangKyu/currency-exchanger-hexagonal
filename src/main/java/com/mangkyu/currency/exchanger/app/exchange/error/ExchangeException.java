package com.mangkyu.currency.exchanger.app.exchange.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;

@Getter
public class ExchangeException extends CommonException {

    public ExchangeException(final ExchangeErrorCode errorCode) {
        super(errorCode);
    }

}