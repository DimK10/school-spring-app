USE `schoolapp`;

LOCK
    TABLES `teachers` WRITE;
INSERT INTO `teachers`
VALUES (1000, 'Fotios', 'Panagiotidis', 2);
#        (1001, 'Dimitrios', 'Dimitriou'),
#        (1002, 'Sofia', 'Karamani'),
#        (1003, 'Eleutheria', 'Petrou');
UNLOCK
    TABLES;

LOCK
    TABLES `students` WRITE;
INSERT INTO `students`
VALUES (1000, 'Nick', 3);
#        (1001, 'Teo'),
#        (1002, 'Sofia'),
#        (1003, 'Maria');
UNLOCK
    TABLES;

LOCK
    TABLES `administrators` WRITE;
INSERT INTO `administrators`
VALUES (1000, 'Kostas', 1);
#        (1001, 'Teo'),
#        (1002, 'Sofia'),
#        (1003, 'Maria');
UNLOCK
    TABLES;

LOCK
    TABLES `courses` WRITE;
INSERT INTO `courses`
VALUES (101, 'Programming'),
       (222, 'Data Mining'),
       (435, 'Data Bases'),
       (876, 'Artificial Intelligence');
UNLOCK
    TABLES;

LOCK
    TABLES `grades` WRITE;
INSERT INTO `grades`
VALUES (1000, 435, 5);
#        (1002, 876, 7),
#        (1003, 222, 6),
#        (1003, 876, 10);
UNLOCK
    TABLES;
