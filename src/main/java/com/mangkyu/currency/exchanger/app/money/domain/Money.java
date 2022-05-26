package com.mangkyu.currency.exchanger.app.money.domain;

import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.error.MoneyErrorCode;
import com.mangkyu.currency.exchanger.app.money.error.MoneyException;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Money {

    private final BigDecimal amount;
    private final Currency currency;

    public static Money of(final long amount, final Currency currency) {
        if (amount <= 0) {
            throw new MoneyException(MoneyErrorCode.INVALID_AMOUNT);
        }

        return new Money(BigDecimal.valueOf(amount), currency);
    }

    public long toLong() {
        return amount.longValue();
    }

    public Money exchange(final double exchangeRate, final Currency target) {
        final long amount = (long) (this.amount.longValue() * exchangeRate);
        return Money.of(amount, target);
    }

}
