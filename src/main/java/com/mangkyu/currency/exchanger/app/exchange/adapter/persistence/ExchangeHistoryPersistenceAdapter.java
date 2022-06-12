package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import com.mangkyu.currency.exchanger.app.exchange.converter.ExchangeConverter;
import com.mangkyu.currency.exchanger.app.exchange.domain.port.out.SaveExchangeHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeHistoryPersistenceAdapter implements SaveExchangeHistoryPort {

    private final ExchangeHistoryPersistenceRepository repository;

    @Override
    public void save(final AddExchangeHistoryRequest request) {
        final ExchangeHistoryEntity result = ExchangeConverter.INSTANCE.toExchangeHistoryEntity(request);
        repository.save(result);
    }

}
