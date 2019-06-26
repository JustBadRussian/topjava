package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.AbstractBaseEntity;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestData {
    public static final int MEAL_START_SEQ = AbstractBaseEntity.START_SEQ;

    public static final LocalDate FROM_DATE = LocalDate.of(2019, 06, 26);
    public static final LocalDate TO_DATE = LocalDate.of(2019, 06, 28);
    public static final LocalDateTime FROM_DATE_TIME = LocalDateTime.of(2019, 06, 24, 9, 0);
    public static final LocalDateTime TO_DATE_TIME = LocalDateTime.of(2019, 06, 25, 13, 0);

    public static final Meal MEAL1 = new Meal(MEAL_START_SEQ + 2, LocalDateTime.of(2019, 6, 24, 9, 0), "Завтрак",500);
    public static final Meal MEAL2 = new Meal(MEAL_START_SEQ + 3, LocalDateTime.of(2019, 6, 24, 13, 0), "Обед",900);
    public static final Meal MEAL3 = new Meal(MEAL_START_SEQ + 4, LocalDateTime.of(2019, 6, 24, 18, 0), "Ужин",700);
    public static final Meal MEAL4 = new Meal(MEAL_START_SEQ + 5, LocalDateTime.of(2019, 6, 25, 9, 0), "Завтрак",500);
    public static final Meal MEAL5 = new Meal(MEAL_START_SEQ + 6, LocalDateTime.of(2019, 6, 25, 13, 0), "Обед",850);
    public static final Meal MEAL6 = new Meal(MEAL_START_SEQ + 7, LocalDateTime.of(2019, 6, 25, 18, 0), "Ужин",650);
    public static final Meal MEAL7 = new Meal(MEAL_START_SEQ + 8, LocalDateTime.of(2019, 6, 27, 23, 0), "Админская еда",2500);
    public static final Meal MEAL8 = new Meal(MEAL_START_SEQ + 9, LocalDateTime.of(2019, 6, 27, 21, 0), "Пользовательская еда",2300);

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user_id", "roles");
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user_id", "roles").isEqualTo(expected);
    }

}
