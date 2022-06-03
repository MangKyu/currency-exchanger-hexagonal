package com.mangkyu.currency.exchanger.app.exchange.converter;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryEntity;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeConverter {

    ExchangeConverter INSTANCE = Mappers.getMapper(ExchangeConverter.class);

    ExchangeHistoryEntity toExchangeHistoryEntity(final AddExchangeHistoryRequest request);

    @Mappings({
            @Mapping(source = "money.currency", target = "source"),
            @Mapping(source = "target", target = "target"),
            @Mapping(source = "rate", target = "rate"),
            @Mapping(expression = "java(money.toLong())", target = "amount")
    })
    AddExchangeHistoryRequest toAddExchangeHistoryRequest(final Money money, final Currency target, final double rate);
}
