package com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.sourceCurrency;
import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.targetCurrency;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ExchangeRateHistoryPersistenceRepositoryTest {

    @Autowired
    private ExchangeRateHistoryPersistenceRepository target;

    @Test
    void temp() {
        final ExchangeRateHistoryEntity result = target.findTopBySourceIsAndTargetIsOrderByCreatedAtDesc(sourceCurrency, targetCurrency);
        assertThat(result).isNull();
    }

}