-- CREATE
--     DATABASE IF NOT EXISTS `schoolapp`;
-- USE
--     `schoolapp`;

CREATE TABLE `teachers`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `Firstname` varchar(45) NOT NULL,
    `Surname`   varchar(45) NOT NULL,
    `U_id` INT NOT NULL,

    PRIMARY KEY (`id`)
);

CREATE TABLE `students`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `Name` varchar(10) NOT NULL,
    `U_id` INT NOT NULL,

    PRIMARY KEY (`id`)
);

# CREATE TABLE `administrators`
# (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `Name` varchar(10) NOT NULL,
#     `U_id` INT         NOT NULL,
#
#     PRIMARY KEY (`id`)
# );

CREATE TABLE `courses`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `Title` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);

# CREATE TABLE `grades`
# (
#     `S_id` int NOT NULL,
#     `C_id`  int NOT NULL,
#     `Grade` int NOT NULL,
#     PRIMARY KEY (`S_id`, `C_id`),
#     KEY `C_id` (`C_id`),
#     CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`S_id`) REFERENCES `students` (`id`),
#     CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`C_id`) REFERENCES `courses` (`id`)
# );

