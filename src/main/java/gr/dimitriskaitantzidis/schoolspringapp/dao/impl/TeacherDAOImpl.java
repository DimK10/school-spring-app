package gr.dimitriskaitantzidis.schoolspringapp.dao.impl;

import gr.dimitriskaitantzidis.schoolspringapp.dao.GenericDAO;
import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.util.BasicValidator;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class TeacherDAOImpl extends GenericDAO<Teacher, Integer> implements ITeacherDAO {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    public TeacherDAOImpl() {
        super(Teacher.class);
    }

    public Optional<Teacher> getTeacherById(int id) throws SQLException {
        try {
            return findById(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "There was a problem retrieving the data in getAllTeachers. Exception is: ", ex);
            throw new SQLException(ex.getMessage());
        }
    }

    public Optional<Teacher> getTeacherByUserId(int id) throws SQLException {
        try {
            Query query = entityManager.createNamedQuery("Teacher.findByUserId", Teacher.class)
                    .setParameter("userId", id);

            return Optional.ofNullable((Teacher) query.getSingleResult());
        } catch (NoResultException nre) {
            String errorMessage = "The user id " + id + " is not associated with a teacher. ";
            LOGGER.log(Level.SEVERE, errorMessage);
            throw new SQLException(errorMessage);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "There was a problem retrieving the data in getTeacherByUserId. Exception is: ", ex);
            throw new SQLException(ex.getMessage());
        }
    }

    @Transactional
    public List<Course> getAssociatedCourses(Teacher teacher) throws NullPointerException, SQLException {
        try {

            BasicValidator.checkNull(teacher);

            Query query = entityManager.createNamedQuery("Course.findAllRelatedCourses")
                    .setParameter("teacherId", teacher.getId());

            return new ArrayList<Course>(query.getResultList());
        } catch (NullPointerException npe) {
            LOGGER.log(Level.SEVERE, npe.getMessage());
            throw npe;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "There was a problem retrieving the data in getAllTeachers. Exception is: ", ex);
            throw new SQLException(ex.getMessage());
        }
    }
}
