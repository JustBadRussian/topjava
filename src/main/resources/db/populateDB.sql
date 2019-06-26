DELETE FROM meals;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
('User', 'user@yandex.ru', 'password'),
('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
('ROLE_USER', 100000),
('ROLE_ADMIN', 100001);

INSERT INTO meals (date_time, description, calories, user_id) VALUES
('2019-06-24 9:00', 'Завтрак', 500, 100000),
('2019-06-24 13:00', 'Обед', 900, 100000),
('2019-06-24 18:00', 'Ужин', 700, 100000),
('2019-06-25 9:00', 'Завтрак', 500, 100001),
('2019-06-25 13:00', 'Обед', 850, 100001),
('2019-06-25 18:00', 'Ужин', 650, 100001),
('2019-06-27 23:00', 'Админская еда', 2500, 100001),
('2019-06-27 21:00', 'Пользовательская еда', 2300, 100000);

