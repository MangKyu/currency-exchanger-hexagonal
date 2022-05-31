package com.mangkyu.currency.exchanger.config;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis.CurrentExchangeRateProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CurrentExchangeRateProperties.class)
class PropertiesConfig {

}
