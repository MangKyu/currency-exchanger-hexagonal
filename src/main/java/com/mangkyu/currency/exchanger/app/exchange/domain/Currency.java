package com.mangkyu.currency.exchanger.app.exchange.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Currency {

    USD(false),
    KRW(true),
    JPY(true),
    PHP(true),
    ;

    private final boolean canBeTarget;

    public String quoteKey(final Currency targetCurrency) {
        return this.name() + targetCurrency.name();
    }

    public static boolean canBeTarget(final Currency target){
        return target != null && target.canBeTarget;
    }

}
