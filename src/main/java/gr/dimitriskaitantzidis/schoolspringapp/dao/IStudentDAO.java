package gr.dimitriskaitantzidis.schoolspringapp.dao;

import gr.dimitriskaitantzidis.schoolspringapp.model.Student;

import java.sql.SQLException;

public interface IStudentDAO {

    void saveStudent(Student student) throws SQLException, IllegalArgumentException;

    void updateStudent(Student student) throws SQLException, IllegalArgumentException;

    void deleteStudent(Student student) throws SQLException, IllegalArgumentException;
}
