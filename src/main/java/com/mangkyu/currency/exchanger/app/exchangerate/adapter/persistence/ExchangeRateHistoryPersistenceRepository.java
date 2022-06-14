package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateHistoryPersistenceRepository extends JpaRepository<ExchangeRateHistoryEntity, Long> {
}
