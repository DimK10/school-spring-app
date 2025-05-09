CREATE TABLE `schoolapp`.`courses_teachers`
(
    `id`   INT NOT NULL,
    `C_id` INT NOT NULL,
    `T_id` INT NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `schoolapp`.`courses_teachers`
    ADD INDEX `C_id_idx` (`C_id` ASC) VISIBLE,
    ADD INDEX `T_id_idx` (`T_id` ASC) VISIBLE;
;
ALTER TABLE `schoolapp`.`courses_teachers`
    ADD CONSTRAINT `C_id`
        FOREIGN KEY (`C_id`)
            REFERENCES `schoolapp`.`courses` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `T_id`
        FOREIGN KEY (`T_id`)
            REFERENCES `schoolapp`.`teachers` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


INSERT INTO schoolapp.courses_teachers (id, C_id, T_id)
VALUES (1, 101, 1000);
INSERT INTO schoolapp.courses_teachers (id, C_id, T_id)
VALUES (2, 222, 1000);
INSERT INTO schoolapp.courses_teachers (id, C_id, T_id)
VALUES (3, 435, 1000);
