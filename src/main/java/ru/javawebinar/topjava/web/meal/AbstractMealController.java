package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;


public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Collection<Meal> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Collection<Meal> getAll(int userId) {
        log.info("getAll");
        return service.getAll(userId);
    }

    public Meal get(int id) {
        return service.get(id);
    }

    public Meal create(Meal meal) {
        service.create(meal);
        return meal;
    }

    public void update(Meal meal) {
        service.update(meal);
    }

    public void delete(int id) {
        service.delete(id);
    }
}
