package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.admin;


import gr.dimitriskaitantzidis.schoolspringapp.model.User;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(User user) {
        super("User with id = " + user.getId() + " does no exist");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
