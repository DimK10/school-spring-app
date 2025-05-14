package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions;

import gr.dimitriskaitantzidis.schoolspringapp.model.BaseEntity;

import java.io.Serial;

public class EntityNotFoundException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(BaseEntity entity) {
        super("Entity with id = " + entity.getId() + " does no exist");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
