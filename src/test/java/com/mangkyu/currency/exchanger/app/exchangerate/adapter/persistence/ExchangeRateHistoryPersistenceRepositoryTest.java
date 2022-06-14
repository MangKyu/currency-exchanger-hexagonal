package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ExchangeRateHistoryPersistenceRepositoryTest {

    @Autowired
    private ExchangeRateHistoryPersistenceRepository target;

}