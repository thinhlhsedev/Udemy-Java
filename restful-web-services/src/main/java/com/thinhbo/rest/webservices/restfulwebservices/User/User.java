package com.thinhbo.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thinhbo.rest.webservices.restfulwebservices.UserPost.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Name should have at least 2 chars")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birth should be in the past")
    private LocalDate birth;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User() {
    }

    public User(Integer id, String name, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
