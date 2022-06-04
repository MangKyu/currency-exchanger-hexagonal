package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("notlocal")
@SpringBootTest(classes = {RestCurrentExchangeRateCallerActivationTest.RestTestConfig.class})
class RestCurrentExchangeRateCallerActivationTest {

    @Autowired
    private CurrentExchangeRateCaller target;

    @Test
    void Local이아니면RestCurrentExchangeRateCaller이활성화() {
        assertThat(target).isNotNull()
                .isInstanceOf(RestCurrentExchangeRateCaller.class);
    }

    @ComponentScan("com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis")
    static class RestTestConfig {

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

}