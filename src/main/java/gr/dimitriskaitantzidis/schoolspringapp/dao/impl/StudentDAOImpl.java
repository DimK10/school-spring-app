package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.IStudentDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Student;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;

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
    public void deleteStudent(Student student) throws SQLException, IllegalArgumentException {

    }
}
