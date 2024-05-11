package com.myorg.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDAOService {
    //JPA/Hibernate > Database

    //UserDaoService > static list
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;
    static {
        users.add(new User(++userCount, "Adam", LocalDateTime.now().minusYears(30)));
        users.add(new User(++userCount, "Eve", LocalDateTime.now().minusYears(25)));
        users.add(new User(++userCount, "Jim", LocalDateTime.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    //public user save(User user);
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    //public user findOne(int id) {};

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
}
