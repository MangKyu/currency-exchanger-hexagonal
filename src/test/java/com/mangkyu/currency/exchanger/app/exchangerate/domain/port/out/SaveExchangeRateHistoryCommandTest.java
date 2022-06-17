package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryPersistenceRepository;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryWritePersistenceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SaveExchangeRateHistoryCommandTest {

    private SaveExchangeRateHistoryCommand target;

    @Autowired
    private ExchangeRateHistoryPersistenceRepository repository;

    @BeforeEach
    void init() {
        target = new ExchangeRateHistoryWritePersistenceAdapter(repository);
    }

    @Test
    void 환율히스토리저장() {
        final AddExchangeRateHistoryRequest request = addExchangeRateHistoryRequest;

        target.save(request);

        assertThat(repository.findAll().size()).isOne();
    }

}