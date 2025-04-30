package gr.dimitriskaitantzidis.schoolspringapp.dao;


import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.repository.TeacherRepository;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TeacherDAOImpl implements ITeacherDAO {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    private final TeacherRepository teacherRepository;


    public TeacherDAOImpl(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void insert(Teacher teacher) throws SQLException {
        // todo
    }

    @Override
    public void delete(Teacher teacher) throws SQLException {
        // todo
    }

    @Override
    public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
        // todo
    }

    @Override
    public List<Teacher> getAllTeachersOrderByLnameFname() throws SQLException {
        try {
            return this.teacherRepository.findAllByOrderBySnameAscFnameAsc();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "There was a problem retrieving the data in getAllTeachers. Exception is: ", ex);
            throw new SQLException(ex.getMessage());
        }

    }

    @Override
    public List<Teacher> getTeachersBySurname(String surname) throws SQLException {
        // todo
        return null;
    }

    @Override
    public Teacher getTeacherById(int id) throws SQLException {
        //todo
        return null;
    }
}


