package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.*;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return ru.javawebinar.topjava.web.SecurityUtil.USERS.remove(get(id));
    }

    @Override
    public User save(User user) {
        log.info("save {}", user);

        for (User usr : SecurityUtil.USERS) {
            if (usr.getName().equals(user.getName())) {
                return null;
            }
        }
        SecurityUtil.USERS.add(user);
        return user;
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return getAll().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        Collections.sort(SecurityUtil.USERS);
        return SecurityUtil.USERS;
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);

        return SecurityUtil.USERS.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .get();
    }
}
