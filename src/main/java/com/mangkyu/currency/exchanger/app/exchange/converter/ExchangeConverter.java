package com.mangkyu.currency.exchanger.app.exchange.converter;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExchangeConverter {

    ExchangeConverter INSTANCE = Mappers.getMapper(ExchangeConverter.class);

    ExchangeHistoryEntity toExchangeHistoryEntity(final AddExchangeHistoryRequest request);

}
