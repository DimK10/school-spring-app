CREATE TABLE `schoolapp`.`users`
(
    `id`        INT         NOT NULL,
    `user_name` VARCHAR(45) NOT NULL,
    `email`     VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `role`      VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);