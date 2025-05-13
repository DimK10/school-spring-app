package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IStudentDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import gr.dimitriskaitantzidis.schoolspringapp.model.User_;
import jakarta.persistence.Query;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
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

    private final ITeacherDAO teacherDAO;

    private final IStudentDAO studentDAO;

    public UserDAOImpl(ITeacherDAO teacherDAO, IStudentDAO studentDAO) {
        super(User.class);
        this.teacherDAO = teacherDAO;
        this.studentDAO = studentDAO;
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
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void saveUser(UserDTO userDTO) throws SQLException, IllegalArgumentException {
        try {
            User newUser = userDTO.toEntity();

            entityManager.persist(newUser);

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_TEACHER)) {
                if (userDTO.getTeacherDTO() == null) {
                    throw new IllegalArgumentException("The teacherDTO in userDTO is null");
                }

                teacherDAO.saveTeacher(userDTO.getTeacherDTO().toEntity(newUser));
            }

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_STUDENT)) {
                if (userDTO.getStudentDTO() == null) {
                    throw new IllegalArgumentException("The studentDTO in userDTO is null");
                }
                studentDAO.saveStudent(userDTO.getStudentDTO().toEntity(newUser));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when saving the user. " + ex);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateUser(UserDTO userDTO) throws SQLException, IllegalArgumentException {
        try {
            Optional<User> existingUserOptional = findById(userDTO.getUserId());

            if (existingUserOptional.isEmpty()) {
                throw new IllegalArgumentException("The user with given id: " +
                        userDTO.getUserId() + " and email " + userDTO.getEmail() +
                        " does not exist");
            }

            User userFromDB = existingUserOptional.get();

            User updatedUser = userDTO.toEntity();

            userFromDB.setUserName(updatedUser.getUserName());
            userFromDB.setEmail(updatedUser.getEmail());
            userFromDB.setRole(updatedUser.getRole());

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_TEACHER)) {
                if (userDTO.getTeacherDTO() == null) {
                    throw new IllegalArgumentException("The teacherDTO in userDTO is null");
                }
                teacherDAO.updateTeacher(userDTO.getTeacherDTO().toEntity(userFromDB));
            }

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_STUDENT)) {
                if (userDTO.getStudentDTO() == null) {
                    throw new IllegalArgumentException("The studentDTO in userDTO is null");
                }
                studentDAO.updateStudent(userDTO.getStudentDTO().toEntity(userFromDB));
            }


        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when updating the user. " + ex);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteUser(int id) throws SQLException, IllegalArgumentException {
        try {

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when deleting the user. " + ex);
        }
    }
}
