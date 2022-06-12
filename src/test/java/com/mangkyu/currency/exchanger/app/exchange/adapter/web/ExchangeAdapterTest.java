package com.mangkyu.currency.exchanger.app.exchange.adapter.web;

import com.google.gson.Gson;
import com.mangkyu.currency.exchanger.app.common.errors.CommonErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ExchangeAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExchangeUseCase exchangeUseCase;

    @Test
    void 환전성공() throws Exception {
        final ExchangeRequest exchangeRequest = ExchangeRequest.builder()
                .amount(amount)
                .sourceCurrency(sourceCurrency)
                .targetCurrency(targetCurrency)
                .build();

        doReturn(exchangedMoney)
                .when(exchangeUseCase)
                .exchangeMoney(money, targetCurrency);

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/exchange")
                .content(new Gson().toJson(exchangeRequest))
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("amount").value(formattedExchangedMoneyAmount))
                .andExpect(jsonPath("currency").value(exchangedMoney.getCurrency().name()));
    }

    @ParameterizedTest
    @CsvSource({"-1,USD,KRW", "0,USD,KRW", "10001,USD,KRW"})
    void 환전실패_잘못된파라미터_양수가아님(final Long amount, final Currency source, final Currency target) throws Exception {
        final ExchangeRequest exchangeRequest = ExchangeRequest.builder()
                .amount(amount)
                .sourceCurrency(source)
                .targetCurrency(target)
                .build();

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/exchange")
                .content(new Gson().toJson(exchangeRequest))
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(CommonErrorCode.INVALID_PARAMETER.name()))
                .andExpect(jsonPath("message").value(CommonErrorCode.INVALID_PARAMETER.getMessage()))
                .andExpect(jsonPath("errors[0].field").value("amount"))
                .andExpect(jsonPath("errors[0].message").value("송금액이 바르지 않습니다."));
    }

    @ParameterizedTest
    @CsvSource({"1,,KRW", "2,KRW,"})
    void 환전실패_잘못된파라미터(final Long amount, final Currency source, final Currency target) throws Exception {
        final ExchangeRequest exchangeRequest = ExchangeRequest.builder()
                .amount(amount)
                .sourceCurrency(source)
                .targetCurrency(target)
                .build();

        final ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/exchange")
                .content(new Gson().toJson(exchangeRequest))
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("code").value(CommonErrorCode.INVALID_PARAMETER.name()))
                .andExpect(jsonPath("message").value(CommonErrorCode.INVALID_PARAMETER.getMessage()));
    }

}