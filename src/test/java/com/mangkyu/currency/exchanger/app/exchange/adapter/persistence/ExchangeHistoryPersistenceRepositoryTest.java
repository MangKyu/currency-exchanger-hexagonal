package com.mangkyu.currency.exchanger.app.exchange.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ExchangeHistoryPersistenceRepositoryTest {

    @Autowired
    private ExchangeHistoryPersistenceRepository target;

}