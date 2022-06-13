package com.mangkyu.currency.exchanger.app.exchange.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryWritePersistenceAdapter;
import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.ExchangeHistoryPersistenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.*;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SaveExchangeHistoryPortTest {

    private SaveExchangeHistoryPort target;

    @Autowired
    private ExchangeHistoryPersistenceRepository repository;

    @BeforeEach
    void init() {
        target = new ExchangeHistoryWritePersistenceAdapter(repository);
    }

    @Test
    void 히스토리추가() {
        final AddExchangeHistoryRequest request = AddExchangeHistoryRequest.builder()
                .source(sourceCurrency)
                .target(targetCurrency)
                .rate(price)
                .amount(amount)
                .build();

        target.save(request);

        assertThat(repository.findAll().size()).isOne();
    }

}