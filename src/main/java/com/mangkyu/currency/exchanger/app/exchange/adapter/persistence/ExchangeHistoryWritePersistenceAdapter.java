package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import com.mangkyu.currency.exchanger.app.exchange.converter.ExchangeConverter;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.SaveExchangeHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ExchangeHistoryWritePersistenceAdapter implements SaveExchangeHistoryPort {

    private final ExchangeHistoryPersistenceRepository repository;

    @Override
    public void save(final AddExchangeHistoryRequest request) {
        final ExchangeHistoryEntity result = ExchangeConverter.INSTANCE.toExchangeHistoryEntity(request);
        repository.save(result);
    }

}
