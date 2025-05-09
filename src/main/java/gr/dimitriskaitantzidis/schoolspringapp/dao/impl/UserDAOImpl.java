package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import gr.dimitriskaitantzidis.schoolspringapp.model.User_;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl extends GenericDAO<User, Integer> implements IUserDAO {

    public UserDAOImpl() {
        super(User.class);
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        return super.findBy(User_.email, email).stream().findFirst();
    }
}
