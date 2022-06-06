package com.mangkyu.currency.exchanger.app.exchangerate.adapter.currencyapis;

import com.google.gson.Gson;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateErrorCode;
import com.mangkyu.currency.exchanger.app.exchangerate.error.ExchangeRateException;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Profile("!local")
@Component
@RequiredArgsConstructor
class RestCurrentExchangeRateCaller implements CurrentExchangeRateCaller {

    private final RestTemplate restTemplate;
    private final Gson gson;
    private final CurrentExchangeRateProperties properties;

    @Override
    public CurrentExchangeRateResponse call(final Currency source, final Currency target) {
        final String result = callApis(source, target);

        if (!isSuccess(result)) {
            throw new ExchangeRateException(ExchangeRateErrorCode.FETCH_EXCHANGE_RATE_FAIL);
        }

        return gson.fromJson(result, CurrentExchangeRateResponse.class);
    }

    private String callApis(final Currency source, final Currency target) {
        return restTemplate.exchange(
                createApiUri(source, target),
                HttpMethod.GET,
                new HttpEntity<>(createHttpHeaders()),
                String.class)
                .getBody();
    }

    private String createApiUri(final Currency source, final Currency target) {
        return UriComponentsBuilder.fromHttpUrl(properties.getUri())
                .queryParam("base", source.name())
                .queryParam("symbols", target.name())
                .encode()
                .toUriString();
    }

    private HttpHeaders createHttpHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("apikey", properties.getKey());
        return headers;
    }

    private boolean isSuccess(final String result) {
        return result.contains("\"success\": true");
    }

}
