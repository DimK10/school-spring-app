package gr.dimitriskaitantzidis.schoolspringapp.dao;

import gr.dimitriskaitantzidis.schoolspringapp.model.Student;

import java.sql.SQLException;
import java.util.Optional;

public interface IStudentDAO {

    Optional<Student> getStudentByUserId(int id) throws SQLException;

    void saveStudent(Student student) throws SQLException, IllegalArgumentException;

    void updateStudent(Student student) throws SQLException, IllegalArgumentException;

    void deleteStudent(int studentId) throws SQLException, IllegalArgumentException;
}
