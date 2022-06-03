package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface ExchangeHistoryPersistenceRepository extends JpaRepository<ExchangeHistoryEntity, Long> {
}
