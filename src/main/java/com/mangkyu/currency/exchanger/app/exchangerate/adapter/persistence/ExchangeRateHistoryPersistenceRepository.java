package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateHistoryPersistenceRepository extends JpaRepository<ExchangeRateHistoryEntity, Long> {

    ExchangeRateHistoryEntity findTopBySourceIsAndTargetIsOrderByCreatedAtDesc(final Currency source, final Currency target);
}
