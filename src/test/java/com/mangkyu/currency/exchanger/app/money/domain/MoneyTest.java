package com.mangkyu.currency.exchanger.app.money.domain;

import com.mangkyu.currency.exchanger.app.money.error.MoneyErrorCode;
import com.mangkyu.currency.exchanger.app.money.error.MoneyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, -10000})
    void Money생성실패_잘못된금액(final long amount) {
        final MoneyException result = assertThrows(MoneyException.class, () -> new Money(amount, sourceCurrency));
        assertThat(result.getErrorCode()).isEqualTo(MoneyErrorCode.INVALID_AMOUNT);
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3})
    void Money생성(final long amount) {
        final Money result = new Money(amount, sourceCurrency);
        assertThat(result).isNotNull();
    }

    @Test
    void 환전() {
        final Money result = money.exchange(price, targetCurrency);

        assertThat(result.getCurrency()).isEqualTo(exchangedMoney.getCurrency());
        assertThat(result.toLong()).isEqualTo(exchangedMoney.toLong());
        assertThat(result).isEqualTo(exchangedMoney);
    }

    @Test
    void 데시말포맷으로변환() {
        final String result = new Money(1_112_141, sourceCurrency).toFormattedAmount();

        assertThat(result).isEqualTo("1,112,141.00");
    }

}
