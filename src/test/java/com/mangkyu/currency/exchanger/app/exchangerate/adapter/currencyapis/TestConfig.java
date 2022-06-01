package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis")
class TestConfig {

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