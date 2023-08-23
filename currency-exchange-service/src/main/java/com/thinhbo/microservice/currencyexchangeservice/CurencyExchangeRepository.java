package com.thinhbo.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
    
    CurrencyExchange findByFromAndTo(String from, String to);
}
