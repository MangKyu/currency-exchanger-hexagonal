package com.mangkyu.currency.exchanger.app.exchangerate.adapter.web;

import com.mangkyu.currency.exchanger.app.common.errors.CommonErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class GetExchangeRateAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GetExchangeRateUseCase exchangeRateUseCase;

    @Test
    void 환율정보조회API호출() throws Exception {
        doReturn(price)
                .when(exchangeRateUseCase)
                .getExchangeRate(sourceCurrency, targetCurrency);

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/exchange-rates")
                .param("source", sourceCurrency.name())
                .param("target", targetCurrency.name()));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("rate").value(formattedPrice))
                .andExpect(jsonPath("unit").value(exchangeUnit));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc"})
    void 환율정보조회API호출실패_Currency가아닌파라미터(final String target) throws Exception {
        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/exchange-rates")
                .param("source", sourceCurrency.name())
                .param("target", target));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(CommonErrorCode.INVALID_PARAMETER.name()))
                .andExpect(jsonPath("message").value(CommonErrorCode.INVALID_PARAMETER.getMessage()));
    }

}