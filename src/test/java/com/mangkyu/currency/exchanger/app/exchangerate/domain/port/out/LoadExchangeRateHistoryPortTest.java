package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryPersistenceRepository;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryReadPersistenceAdapter;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryWritePersistenceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.sourceCurrency;
import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.targetCurrency;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoadExchangeRateHistoryPortTest {

    private LoadExchangeRateHistoryPort target;

    @Autowired
    private ExchangeRateHistoryPersistenceRepository repository;

    @BeforeEach
    void init() {
        target = new ExchangeRateHistoryReadPersistenceAdapter(repository);
    }

    @Test
    void 조회성공() {
        target.loadLatest(sourceCurrency, targetCurrency);
    }

}