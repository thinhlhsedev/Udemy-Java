package com.thinhbo.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {
        // CurrencyExchange currency = new CurrencyExchange(1000L, from, to,
        // BigDecimal.valueOf(50));
        CurrencyExchange currency = repository.findByFromAndTo(from, to);
        if (currency == null) {
            throw new RuntimeException("Unable to find " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currency.setEnvironment(port);
        // repository

        return currency;
    }
}
