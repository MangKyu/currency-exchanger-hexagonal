package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.SaveExchangeRateHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class ExchangeRateHistoryWritePersistenceAdapter implements SaveExchangeRateHistoryPort {

    private final ExchangeRateHistoryPersistenceRepository repository;

    @Override
    public void save(final AddExchangeRateHistoryRequest request) {
        final ExchangeRateHistoryEntity entity = ExchangeRateConverter.INSTANCE.toAddExchangeRateHistoryRequest(request);
        repository.save(entity);
    }
}
