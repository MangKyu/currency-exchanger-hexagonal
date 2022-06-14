package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRateHistoryPersistenceRepository extends JpaRepository<ExchangeRateHistoryEntity, Long> {

    Optional<ExchangeRateHistoryEntity> findTopBySourceIsAndTargetIsOrderByCreatedAtDesc(final Currency source, final Currency target);
}
