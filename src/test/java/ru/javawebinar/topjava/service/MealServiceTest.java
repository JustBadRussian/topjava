package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal userMeal = service.get(MEAL1.getId(), USER_ID);
        Meal adminMeal = service.get(MEAL6.getId(), ADMIN_ID);
        assertMatch(MEAL1, userMeal);
        assertMatch(MEAL6, adminMeal);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        service.get(MEAL1.getId(), FAKE_USER_ID);
    }

    @Test
    public void delete() {
        service.delete(MEAL2.getId(), USER_ID);
        service.delete(MEAL5.getId(), ADMIN_ID);
        assertMatch(service.getAll(USER_ID), MEAL8, MEAL3, MEAL1);
        assertMatch(service.getAll(ADMIN_ID), MEAL7, MEAL6, MEAL4);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        service.delete(MEAL1.getId(), FAKE_USER_ID);
    }

    @Test
    public void getBetweenDates() {
        assertMatch(service.getBetweenDates(FROM_DATE, TO_DATE, ADMIN_ID), MEAL7);
        assertMatch(service.getBetweenDates(FROM_DATE, TO_DATE, USER_ID), MEAL8);
    }

    @Test
    public void getBetweenDateTimes() {
        assertMatch(service.getBetweenDateTimes(FROM_DATE_TIME, TO_DATE_TIME, ADMIN_ID), MEAL5, MEAL4);
        assertMatch(service.getBetweenDateTimes(FROM_DATE_TIME, TO_DATE_TIME, USER_ID), MEAL3,MEAL2, MEAL1);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(USER_ID), MEAL8, MEAL3, MEAL2, MEAL1);
        assertMatch(service.getAll(ADMIN_ID), MEAL7, MEAL6, MEAL5, MEAL4);
    }

    @Test
    public void update() {
        Meal upd = new Meal(MEAL1);
        upd.setCalories(1500);
        upd.setDescription("Просто еда");
        service.update(upd, USER_ID);
        assertMatch(service.get(MEAL1.getId(), USER_ID), upd);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() {
        Meal meal = service.get(MEAL1.getId(), USER_ID);
        service.update(meal, FAKE_USER_ID);
    }

    @Test
    public void create() {
        Meal newMeal = new Meal(null, LocalDateTime.of(2019, 6, 26, 15, 20), "Полдник",800);
        Meal created = service.create(newMeal, USER_ID);
        newMeal.setId(created.getId());
        assertMatch(service.getAll(USER_ID), MEAL8, newMeal, MEAL3, MEAL2, MEAL1);
    }
}