package com.mangkyu.currency.exchanger.app.exchangerate.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;

@Getter
public class ExchangeRateException extends CommonException {

    public ExchangeRateException(final ExchangeRateErrorCode errorCode) {
        super(errorCode);
    }

}