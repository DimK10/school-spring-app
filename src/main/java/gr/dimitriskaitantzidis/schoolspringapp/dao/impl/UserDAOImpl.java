package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IStudentDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IUserDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Record;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import gr.dimitriskaitantzidis.schoolspringapp.model.Student;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import gr.dimitriskaitantzidis.schoolspringapp.model.User_;
import gr.dimitriskaitantzidis.schoolspringapp.util.PasswordHashGenerator;
import jakarta.persistence.NoResultException;
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
    public Optional<UserDTO> getUserDTOById(int id) throws SQLException {
        try {
            Query query = entityManager.createNamedQuery("User.getUserDTONative")
                    .setParameter("userId", id);
            return Optional.ofNullable((UserDTO) query.getSingleResult());
        } catch (NoResultException ex) {
            LOGGER.log(Level.SEVERE, "The user with given id: " + id + " was not found." + ex.getMessage(), ex);
            throw new SQLException("There was an error when saving the user. " + ex);
        }
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
            User newUser = userDTO.toEntity(Record.CREATE);


            newUser.setPassword(PasswordHashGenerator.hashPassword(userDTO.getPassword()));

            entityManager.persist(newUser);

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_TEACHER)) {
                if (userDTO.getTeacherDTO() == null) {
                    throw new IllegalArgumentException("The teacherDTO in userDTO is null");
                }

                teacherDAO.saveTeacher(userDTO.getTeacherDTO().toEntity(Record.CREATE, newUser));
            }

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_STUDENT)) {
                if (userDTO.getStudentDTO() == null) {
                    throw new IllegalArgumentException("The studentDTO in userDTO is null");
                }
                studentDAO.saveStudent(userDTO.getStudentDTO().toEntity(Record.CREATE, newUser));
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

            User updatedUser = userDTO.toEntity(Record.UPDATE);

            userFromDB.setUserName(updatedUser.getUserName());
            userFromDB.setEmail(updatedUser.getEmail());
            userFromDB.setRole(updatedUser.getRole());
            userFromDB.setName(userDTO.getName());

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_TEACHER)) {
                if (userDTO.getTeacherDTO() == null) {
                    throw new IllegalArgumentException("The teacherDTO in userDTO is null");
                }
                Optional<Teacher> teacherOptional = teacherDAO.getTeacherByUserId(userFromDB.getId());

                if (teacherOptional.isEmpty()) {
                    throw new IllegalArgumentException("The teacherDTO in userDTO is null");
                }

                Teacher teacherFromDB = teacherOptional.get();

                teacherFromDB.setFname(userDTO.getName().substring(0, 1));
                teacherFromDB.setSname(userDTO.getName().substring(1));

                teacherDAO.updateTeacher(teacherFromDB);
            }

            if (Role.valueOf(userDTO.getRole()).equals(Role.ROLE_STUDENT)) {
                if (userDTO.getStudentDTO() == null) {
                    throw new IllegalArgumentException("Could not retrieve teacher record from user id " + userDTO.getUserId());
                }

                Optional<Student> studentOptional = studentDAO.getStudentByUserId(userFromDB.getId());

                if (studentOptional.isEmpty()) {
                    throw new IllegalArgumentException("Could not retrieve student record from user id " + userDTO.getUserId());
                }

                Student studentFromDb = studentOptional.get();

                studentFromDb.setName(userDTO.getName());


                studentDAO.updateStudent(studentFromDb);
            }


        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when updating the user. " + ex);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteUser(int userId) throws SQLException, IllegalArgumentException {
        try {

            Optional<User> existingUserOptional = findById(userId);
            if (existingUserOptional.isEmpty()) {
                throw new IllegalArgumentException("The user with given id " + userId + " does not exist");
            }

            User userFromDB = existingUserOptional.get();

            if ((userFromDB.getRole()).equals(Role.ROLE_TEACHER)) {
                teacherDAO.deleteTeacher(userFromDB.getTeacher().getId());
            }


            if ((userFromDB.getRole()).equals(Role.ROLE_STUDENT)) {
                studentDAO.deleteStudent(userFromDB.getStudent().getId());
            }

            entityManager.remove(userFromDB);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when deleting the user. " + ex);
        }
    }
}
