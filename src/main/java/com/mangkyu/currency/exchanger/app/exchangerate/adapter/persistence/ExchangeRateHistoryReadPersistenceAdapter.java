package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out.LoadExchangeRateHistoryPort;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExchangeRateHistoryReadPersistenceAdapter implements LoadExchangeRateHistoryPort {

    private final ExchangeRateHistoryPersistenceRepository repository;

    @Override
    public void loadLatest(final Currency sourceCurrency, final Currency targetCurrency) {
        repository.findTopBySourceIsAndTargetIsOrderByCreatedAtDesc(sourceCurrency, targetCurrency);
    }

}
