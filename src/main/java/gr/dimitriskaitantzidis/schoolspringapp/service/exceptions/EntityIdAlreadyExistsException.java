package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions;

import gr.dimitriskaitantzidis.schoolspringapp.model.BaseEntity;

import java.io.Serial;

public class EntityIdAlreadyExistsException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityIdAlreadyExistsException(BaseEntity entity) {
        super("Entity with id = " + entity.getId() + " already exist");
    }
}
