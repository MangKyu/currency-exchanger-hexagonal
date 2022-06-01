package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@SpringBootTest(classes = {LocalCurrentExchangeRateCallerActivationTest.LocalTestConfig.class})
class LocalCurrentExchangeRateCallerActivationTest {

    @Autowired
    private CurrentExchangeRateCaller target;

    @Test
    void Local에서는LocalCurrentExchangeRateCaller이활성화() {
        assertThat(target).isNotNull()
                .isInstanceOf(LocalCurrentExchangeRateCaller.class);
    }

    @ComponentScan("com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis")
    static class LocalTestConfig {

        @Bean
        Gson gson() {
            return new Gson();
        }

    }

}