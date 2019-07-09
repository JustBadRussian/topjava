package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserServiceTest;

@ActiveProfiles({"postgres", "datajpa"})
public class DataJpaUserServiceTest extends UserServiceTest {

}