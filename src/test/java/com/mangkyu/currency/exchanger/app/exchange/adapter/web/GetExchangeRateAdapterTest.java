package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.mangkyu.currency.exchanger.app.common.errors.CommonErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.GetExchangeRateUseCase;
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
import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.roundedPrice;
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
                .getExchangeRate(Currency.KRW);

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("target", Currency.KRW.name()));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("rate").value(roundedPrice));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "USD"})
    void 환율정보조회API호출실패_비어있거나USD(final String target) throws Exception {
        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("target", target));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(ExchangeErrorCode.INVALID_TARGET_CURRENCY.name()))
                .andExpect(jsonPath("message").value(ExchangeErrorCode.INVALID_TARGET_CURRENCY.getMessage()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc"})
    void 환율정보조회API호출실패_Currency가아닌파라미터(final String target) throws Exception {
        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/exchange-rates")
                .param("target", target));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(CommonErrorCode.INVALID_PARAMETER.name()))
                .andExpect(jsonPath("message").value(CommonErrorCode.INVALID_PARAMETER.getMessage()));
    }

}