package com.mangkyu.currency.exchanger.app.exchange.adapter.view;

import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ExchangeViewController {

    @GetMapping("/exchange")
    public String exchange(final Model model) {
        model.addAttribute("sourceCurrencies", Currency.sourceCurrencies());
        model.addAttribute("targetCurrencies", Currency.targetCurrencies());

        return "/exchange";
    }

}
