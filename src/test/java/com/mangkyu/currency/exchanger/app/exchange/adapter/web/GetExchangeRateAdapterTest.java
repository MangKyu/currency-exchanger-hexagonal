package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.price;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GetExchangeRateAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void 환율정보조회API호출() throws Exception {
        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("target", Currency.KRW.name()));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("rate", price).exists());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", " ", "USD"})
    void 환율정보조회API호출실패_잘못된파라미터(final String target) throws Exception {
        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("target", target));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code", ExchangeErrorCode.INVALID_TARGET_CURRENCY).exists())
                .andExpect(jsonPath("message", ExchangeErrorCode.INVALID_TARGET_CURRENCY.getMessage()).exists());
    }

}