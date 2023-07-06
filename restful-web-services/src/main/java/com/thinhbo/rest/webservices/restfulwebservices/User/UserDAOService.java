package com.thinhbo.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now()));
        users.add(new User(++userCount, "Lynx", LocalDate.now()));
        users.add(new User(++userCount, "Bul", LocalDate.now()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User addUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
