USE schoolapp;

LOCK
    TABLES `users` WRITE;

INSERT INTO schoolapp.users (id, user_name, email, password, role)
VALUES (1, 'john_doe', 'jdoe@test.com', '$2a$10$T0JT/l5iDgjp68BU3b89ZOPP9pDAzT5DBmUBKz8UD.uy2EUqe4ToS', 'ROLE_ADMIN');

INSERT INTO schoolapp.users (id, user_name, email, password, role)
VALUES (2, 'foo_nbar', 'fbar@test.com', '$2a$10$T0JT/l5iDgjp68BU3b89ZOPP9pDAzT5DBmUBKz8UD.uy2EUqe4ToS', 'ROLE_TEACHER');

INSERT INTO schoolapp.users (id, user_name, email, password, role)
VALUES (3, 'kay_joe', 'kjoe@test.com', '$2a$10$T0JT/l5iDgjp68BU3b89ZOPP9pDAzT5DBmUBKz8UD.uy2EUqe4ToS', 'ROLE_STUDENT');

UNLOCK
    TABLES;