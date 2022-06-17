package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.exchangerate.converter.ExchangeRateConverter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateHistoryQuery;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExchangeRateHistoryReadPersistenceAdapter implements LoadExchangeRateHistoryQuery {

    private final ExchangeRateHistoryPersistenceRepository repository;

    @Override
    public ExchangeRate loadLatest(final Currency source, final Currency target) {
        final ExchangeRateHistoryEntity entity = repository.findTopBySourceIsAndTargetIsOrderByCreatedAtDesc(source, target)
                .orElseGet(() -> createEmptyEntity(source, target));

        return ExchangeRateConverter.INSTANCE.toExchangeRate(entity);
    }

    private ExchangeRateHistoryEntity createEmptyEntity(final Currency source, final Currency target) {
        return ExchangeRateHistoryEntity.builder()
                .source(source)
                .target(target)
                .price(0d)
                .build();
    }

}
