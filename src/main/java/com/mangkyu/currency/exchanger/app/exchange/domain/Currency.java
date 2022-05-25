package com.mangkyu.currency.exchanger.app.exchange.domain;

public enum Currency {

    USD,
    KRW,
    JPY,
    PHP,
    ;

    public String quoteKey(final Currency targetCurrency) {
        return this.name() + targetCurrency.name();
    }

}
