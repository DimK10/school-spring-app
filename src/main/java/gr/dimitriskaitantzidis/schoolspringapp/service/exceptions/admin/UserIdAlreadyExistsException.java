package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.admin;


import gr.dimitriskaitantzidis.schoolspringapp.model.User;

public class UserIdAlreadyExistsException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserIdAlreadyExistsException(User user) {
        super("User with id = " + user.getId() + " already exist");
    }

}
