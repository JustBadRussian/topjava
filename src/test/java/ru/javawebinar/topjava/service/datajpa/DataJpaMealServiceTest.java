package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.MealServiceTest;

@ActiveProfiles({"postgres", "datajpa"})
public class DataJpaMealServiceTest extends MealServiceTest {

}