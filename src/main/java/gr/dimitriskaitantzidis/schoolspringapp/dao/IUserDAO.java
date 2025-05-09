package gr.dimitriskaitantzidis.schoolspringapp.dao;

import gr.dimitriskaitantzidis.schoolspringapp.model.User;

import java.util.Optional;

public interface IUserDAO {

    Optional<User> getUserByEmail(String email);
}
