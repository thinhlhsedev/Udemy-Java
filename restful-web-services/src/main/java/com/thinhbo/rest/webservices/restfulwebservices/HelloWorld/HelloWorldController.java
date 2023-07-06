package com.thinhbo.rest.webservices.restfulwebservices.HelloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld()
    {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public String helloWorldBean()
    {
        return new HelloWorldBean("Hello World Bean").getMessage();
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public String helloWorldBean(@PathVariable String name)
    {
        return new HelloWorldBean(String.format("Hello World Bean: %s", name)).getMessage();
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized()
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Defaul Message", locale);
    }
}
