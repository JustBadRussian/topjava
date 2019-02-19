package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {

    private static int authUserId = 1;

    public static final List<User> USERS = Arrays.asList(
            new User(0, "Федор Петров", "victor@gmail.com", "012345abC", Role.ROLE_USER, Role.values()),
            new User(1, "Елена Сидорова", "elena@gmail.com", "789450drE", Role.ROLE_USER, Role.values()),
            new User(2, "Максим Дмитриев", "evgeniy@gmail.com", "987654zdC", Role.ROLE_USER, Role.values())
    );

    public static int getAuthUserId() {
        return authUserId;
    }

    public static int setAuthUserId(int userId) {
        authUserId = userId;
        return authUserId;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}