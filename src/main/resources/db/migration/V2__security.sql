CREATE TABLE `schoolapp`.`users`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(45) NOT NULL,
    `email`     VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `role`      VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);


# ALTER TABLE `schoolapp`.`administrators`
#     ADD CONSTRAINT `administrators_fk_1` FOREIGN KEY (`U_id`) REFERENCES `users` (`id`);

ALTER TABLE `schoolapp`.`teachers`
    ADD CONSTRAINT `teachers_fk_1` FOREIGN KEY (`U_id`) REFERENCES `users` (`id`);

ALTER TABLE `schoolapp`.`students`
    ADD CONSTRAINT `students_fk_1` FOREIGN KEY (`U_id`) REFERENCES `users` (`id`);
