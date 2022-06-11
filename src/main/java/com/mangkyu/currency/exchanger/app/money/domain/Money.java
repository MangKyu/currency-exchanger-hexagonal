package com.mangkyu.currency.exchanger.app.money.domain;

import com.mangkyu.currency.exchanger.app.money.error.MoneyErrorCode;
import com.mangkyu.currency.exchanger.app.money.error.MoneyException;
import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Money {

    private final BigDecimal amount;
    private final Currency currency;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###.00");

    public Money(final long amount, final Currency currency) {
        if (amount <= 0) {
            throw new MoneyException(MoneyErrorCode.INVALID_AMOUNT);
        }

        this.amount = BigDecimal.valueOf(amount);
        this.currency = currency;
    }

    public long toLong() {
        return amount.longValue();
    }

    public Money exchange(final double exchangeRate, final Currency target) {
        final long amount = (long) (this.amount.longValue() * exchangeRate);
        return new Money(amount, target);
    }

    public String toFormattedAmount() {
        return DECIMAL_FORMAT.format(amount);
    }

}
