package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan("com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis")
class CurrencyApisTestConfig {

    @Bean
    Gson gson() {
        return new Gson();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CurrentExchangeRateProperties properties() {
        return new CurrentExchangeRateProperties("uri", "key");
    }

}