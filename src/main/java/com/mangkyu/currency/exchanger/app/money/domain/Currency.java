package com.mangkyu.currency.exchanger.app.money.domain;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Currency {

    USD("미국", false),
    KRW("한국", true),
    JPY("일본", true),
    PHP("필리핀", true),
    ;

    private final String nation;
    private final boolean canBeTarget;

    public String quoteKey(final Currency targetCurrency) {
        return this.name() + targetCurrency.name();
    }

    public String toViewString() {
        return nation + "(" + name() + ")";
    }

    public static boolean canBeTarget(final Currency target){
        return target != null && target.canBeTarget;
    }

    public static List<Currency> sourceCurrencies() {
        return Arrays.stream(values())
                .filter(v -> !v.canBeTarget)
                .collect(Collectors.toList());
    }

    public static List<Currency> targetCurrencies() {
        return Arrays.stream(values())
                .filter(v -> v.canBeTarget)
                .collect(Collectors.toList());
    }

}
