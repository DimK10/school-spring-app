package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import gr.dimitriskaitantzidis.schoolspringapp.model.User_;
import jakarta.persistence.Query;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl extends GenericDAO<User, Integer> implements IUserDAO {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    public UserDAOImpl() {
        super(User.class);
    }


    @Override
    public Optional<User> getUserByEmail(String email) {
        return super.findBy(User_.email, email).stream().findFirst();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return super.findById(id).stream().findFirst();
    }

    @Override
    public List<UserDTO> getAllUsersOrderByName() {
        Query query = entityManager.createNamedQuery("User.getAllUsersOrderByNameNative");

        List<UserDTO> users = new ArrayList<>();
        users = (List<UserDTO>) query.getResultList();

        return users;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserDTO user) throws SQLException {
        try {
            User newUser = user.toEntity();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when saving the user. " + ex);
        }

    }

    @Override
    public void updateUser(UserDTO user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
