package com.mangkyu.currency.exchanger.app.exchange.application.converter;

import com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.exchange.domain.Currency;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangePrice;
import com.mangkyu.currency.exchanger.app.exchange.domain.ExchangeRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeConverter {

    ExchangeConverter INSTANCE = Mappers.getMapper(ExchangeConverter.class);

    default ExchangeRate toExchangeRate(final CurrentExchangeRateResponse response, final Currency target) {
        // TODO(MinKyu): Mapstruct 기능을 이용해 처리할 수 있을까..??
        final Currency source = response.getSource();

        return ExchangeRate.builder()
                .source(source)
                .target(target)
                .price(new ExchangePrice(response.getRate(source.quoteKey(target))))
                .build();
    }

}
