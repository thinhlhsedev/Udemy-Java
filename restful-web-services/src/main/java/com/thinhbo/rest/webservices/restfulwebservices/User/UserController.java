package com.thinhbo.rest.webservices.restfulwebservices.User;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserController {
    private UserDAOService service;

    public UserController(UserDAOService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> retriveAllUsers() {
        return service.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retriveUser(@PathVariable int id) {
        User user = service.findUser(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    @GetMapping(path = "/users/{id}/hateoas")
    public EntityModel<User> retriveUserHateoas(@PathVariable int id) {
        User user = service.findUser(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retriveAllUsers());
        entityModel.add(link.withRel("all-user"));

        return entityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUser(id);
    }

}
