package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryEntity;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryPersistenceRepository;
import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.ExchangeRateHistoryReadPersistenceAdapter;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.ExchangeRate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.sourceCurrency;
import static com.mangkyu.currency.exchanger.app.exchangerate.testbase.ExchangeTestBase.targetCurrency;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LoadExchangeRateHistoryQueryTest {

    private LoadExchangeRateHistoryQuery target;

    @Autowired
    private ExchangeRateHistoryPersistenceRepository repository;

    @BeforeEach
    void init() {
        target = new ExchangeRateHistoryReadPersistenceAdapter(repository);
    }

    @Test
    void 조회성공_빈값() {
        final ExchangeRate result = target.loadLatest(sourceCurrency, targetCurrency);

        assertThat(result.getSource()).isEqualTo(sourceCurrency);
        assertThat(result.getTarget()).isEqualTo(targetCurrency);
        assertThat(result.getPrice()).isEqualTo(0d);
    }

    @Test
    void 조회성공_마지막값() {
        final ExchangeRateHistoryEntity entity1 = ExchangeRateHistoryEntity.builder()
                .source(sourceCurrency)
                .target(targetCurrency)
                .price(1d)
                .build();

        final ExchangeRateHistoryEntity entity2 = ExchangeRateHistoryEntity.builder()
                .source(sourceCurrency)
                .target(targetCurrency)
                .price(2d)
                .build();

        repository.saveAll(Arrays.asList(entity1, entity2));

        final ExchangeRate result = target.loadLatest(sourceCurrency, targetCurrency);

        assertThat(result.getSource()).isEqualTo(sourceCurrency);
        assertThat(result.getTarget()).isEqualTo(targetCurrency);
        assertThat(result.getPrice()).isNotEqualTo(entity1.getPrice());
        assertThat(result.getPrice()).isEqualTo(entity2.getPrice());
    }

}