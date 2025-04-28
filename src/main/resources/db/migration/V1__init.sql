CREATE
    DATABASE IF NOT EXISTS `schoolapp`;
USE
    `schoolapp`;

CREATE TABLE `teachers`
(
    `T_id`      int         NOT NULL,
    `Firstname` varchar(45) NOT NULL,
    `Surname`   varchar(45) NOT NULL,
    PRIMARY KEY (`T_id`)
);

CREATE TABLE `students`
(
    `S_am` int         NOT NULL,
    `Name` varchar(10) NOT NULL,
    PRIMARY KEY (`S_am`)
);

CREATE TABLE `courses`
(
    `C_id`  int         NOT NULL,
    `Title` varchar(50) NOT NULL,
    PRIMARY KEY (`C_id`)
);

CREATE TABLE `grades`
(
    `S_am`  int NOT NULL,
    `C_id`  int NOT NULL,
    `Grade` int NOT NULL,
    PRIMARY KEY (`S_am`, `C_id`),
    KEY `C_id` (`C_id`),
    CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`S_am`) REFERENCES `students` (`S_am`),
    CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`C_id`) REFERENCES `courses` (`C_id`)
);

