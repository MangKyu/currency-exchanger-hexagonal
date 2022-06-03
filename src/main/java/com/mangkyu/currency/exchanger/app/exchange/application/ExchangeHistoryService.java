package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryEntity;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryPersistenceRepository;
import com.mangkyu.currency.exchanger.app.exchange.converter.ExchangeConverter;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.SaveExchangeHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeHistoryService implements SaveExchangeHistoryPort {

    private final ExchangeHistoryPersistenceRepository repository;

    @Override
    public void add(final AddExchangeHistoryRequest request) {
        final ExchangeHistoryEntity result = ExchangeConverter.INSTANCE.toExchangeHistoryEntity(request);
        repository.save(result);
    }

}
