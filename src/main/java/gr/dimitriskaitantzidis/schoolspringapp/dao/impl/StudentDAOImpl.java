package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IStudentDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Student;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class StudentDAOImpl extends GenericDAO<Student, Integer> implements IStudentDAO {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    public StudentDAOImpl() {
        super(Student.class);
    }

    @Override
    public Optional<Student> getStudentByUserId(int id) throws SQLException {
        try {
            Query query = entityManager.createNamedQuery("Student.findByUserId", Student.class)
                    .setParameter("userId", id);

            return Optional.ofNullable((Student) query.getSingleResult());
        } catch (NoResultException nre) {
            String errorMessage = "The user id " + id + " is not associated with a Student. ";
            LOGGER.log(Level.SEVERE, errorMessage);
            throw new SQLException(errorMessage);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "There was a problem retrieving the data in getStudentByUserId. Exception is: ", ex);
            throw new SQLException(ex.getMessage());
        }
    }

    @Override
    public void saveStudent(Student student) throws SQLException, IllegalArgumentException {
        try {
            entityManager.persist(student);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when saving the student. " + ex);
        }
    }

    @Override
    public void updateStudent(Student updatedStudent) throws SQLException, IllegalArgumentException {
        try {
            Optional<Student> existingStudentOptional = findById(updatedStudent.getId());

            if (existingStudentOptional.isEmpty()) {
                throw new IllegalArgumentException("The student with given id: " +
                        updatedStudent.getId() + " does not exist");
            }

            Student studentFromDb = existingStudentOptional.get();

            studentFromDb.setName(updatedStudent.getName());

            entityManager.merge(studentFromDb);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when saving the student. " + ex);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteStudent(int studentId) throws SQLException, IllegalArgumentException {
        try {
            Optional<Student> studentOptional = findById(studentId);
            if (studentOptional.isEmpty()) {
                throw new IllegalArgumentException("The student with given id " + studentId + " does not exist");
            }
            entityManager.remove(studentOptional.get());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            throw new SQLException("There was an error when deleting the student. " + ex);
        }
    }
}
