package com.mangkyu.currency.exchanger.app.exchange.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis.ExchangeRateApiAdapter;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import com.mangkyu.currency.exchanger.app.exchange.testbase.TestExchangeRateApiCaller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static com.mangkyu.currency.exchanger.app.exchange.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LoadExchangeRatePortTest {

    private LoadExchangeRatePort target;
    private TestExchangeRateApiCaller exchangeRateCaller;

    @BeforeEach
    void init() {
        exchangeRateCaller = new TestExchangeRateApiCaller();
        target = new ExchangeRateApiAdapter(exchangeRateCaller);
    }

    @Test
    void 환율정보조회실패_비어있는값() {
        final ExchangeException result = assertThrows(ExchangeException.class, () -> target.getExchangeRate(sourceCurrency, targetCurrency));

        assertThat(result.getErrorCode()).isEqualTo(ExchangeErrorCode.FETCH_EXCHANGE_RATE_FAIL);
    }

    @Test
    void 환율정보조회성공() {
        exchangeRateCaller.setQuotes(Collections.singletonMap(quoteKey, price));

        final ExchangeRate result = target.getExchangeRate(sourceCurrency, targetCurrency);

        assertThat(result).isNotNull();
        assertThat(result.getPrice()).isEqualTo(price);
    }

}