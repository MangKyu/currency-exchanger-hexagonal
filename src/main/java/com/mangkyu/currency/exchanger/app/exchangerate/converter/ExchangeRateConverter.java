package com.mangkyu.currency.exchanger.app.exchangerate.converter;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateResponse;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryEntity;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangePrice;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeRateConverter {

    ExchangeRateConverter INSTANCE = Mappers.getMapper(ExchangeRateConverter.class);

    default ExchangeRate toExchangeRate(final CurrentExchangeRateResponse response, final Currency target) {
        // TODO(MinKyu): Mapstruct 기능을 이용해 처리할 수 있을까..??
        final Currency source = response.getSource();

        return ExchangeRate.builder()
                .source(source)
                .target(target)
                .price(new ExchangePrice(response.getRate(source.quoteKey(target))))
                .build();
    }

    ExchangeRateHistoryEntity toExchangeRateHistoryEntity(AddExchangeRateHistoryRequest request);

    AddExchangeRateHistoryRequest toAddExchangeRateHistoryRequest(final ExchangeRate exchangeRate);
}
