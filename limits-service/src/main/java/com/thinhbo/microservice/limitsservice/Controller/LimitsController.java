package com.thinhbo.microservice.limitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinhbo.microservice.limitsservice.Configuration.Configuration;

@RestController
public class LimitsController {
    
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits rertrieveLimits(){
        //return new Limits(0, 0);
        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
