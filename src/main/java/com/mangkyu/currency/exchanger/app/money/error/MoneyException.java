package com.mangkyu.currency.exchanger.app.money.error;

import com.mangkyu.currency.exchanger.app.common.errors.CommonException;
import lombok.Getter;

@Getter
public class MoneyException extends CommonException {

    public MoneyException(final MoneyErrorCode errorCode) {
        super(errorCode);
    }

}