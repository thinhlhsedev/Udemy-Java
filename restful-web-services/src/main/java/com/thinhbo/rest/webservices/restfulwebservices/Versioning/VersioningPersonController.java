package com.thinhbo.rest.webservices.restfulwebservices.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonParam() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", headers = "version=1")
    public PersonV1 getFirstVersionOfPersonHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "version=2")
    public PersonV2 getSecondVersionOfPersonHeader() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/accept", produces = "application/version1+json")
    public PersonV1 getFirstVersionOfPersonAccept() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/version2+json")
    public PersonV2 getSecondVersionOfPersonAccept() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
