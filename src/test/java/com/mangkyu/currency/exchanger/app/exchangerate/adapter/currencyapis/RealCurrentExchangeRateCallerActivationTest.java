package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("notlocal")
@SpringBootTest(classes = {CurrencyApisTestConfig.class})
class RealCurrentExchangeRateCallerActivationTest {

    @Autowired
    private CurrentExchangeRateCaller target;

    @Test
    void Local이아니면RealCurrentExchangeRateCaller이활성화() {
        assertThat(target).isNotNull()
                .isInstanceOf(RealCurrentExchangeRateCaller.class);
    }

}