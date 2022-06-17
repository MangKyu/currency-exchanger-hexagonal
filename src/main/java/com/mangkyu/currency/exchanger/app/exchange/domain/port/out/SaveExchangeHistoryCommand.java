package com.mangkyu.currency.exchanger.app.exchange.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchange.adapter.persistence.AddExchangeHistoryRequest;

public interface SaveExchangeHistoryCommand {

    void save(final AddExchangeHistoryRequest request);

}
