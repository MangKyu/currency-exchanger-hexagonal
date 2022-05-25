package com.mangkyu.currency.exchanger.config;

import com.mangkyu.currency.exchanger.app.exchange.adapter.currencyapis.CurrentExchangeRateProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CurrentExchangeRateProperties.class)
class PropertiesConfig {

}
