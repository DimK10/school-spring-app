package gr.dimitriskaitantzidis.schoolspringapp.dao;


import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface ITeacherDAO {

	Optional<Teacher> getTeacherById(int id) throws SQLException;

	Optional<Teacher> getTeacherByUserId(int id) throws SQLException;

	List<Course> getAssociatedCourses(Teacher teacher) throws SQLException;

	void saveTeacher(Teacher teacher) throws SQLException, IllegalArgumentException;

	void updateTeacher(Teacher teacher) throws SQLException, IllegalArgumentException;

	void deleteTeacher(int teacherId) throws SQLException, IllegalArgumentException;
}
