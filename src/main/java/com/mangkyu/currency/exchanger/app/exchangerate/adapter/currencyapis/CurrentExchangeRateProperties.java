package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties("exchange.currency.api")
@RequiredArgsConstructor
public class CurrentExchangeRateProperties {

    private final String uri;
    private final String key;

}
