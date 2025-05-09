package gr.dimitriskaitantzidis.schoolspringapp.dao;


import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface ITeacherDAO {
	//	void insert(Teacher teacher) throws SQLException;
//	void delete(Teacher teacher) throws SQLException;
//	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
//	List<Teacher> getAllTeachersOrderByLnameFname() throws SQLException;
//	List<Teacher> getTeachersBySurname(String surname) throws SQLException;
	Optional<Teacher> getTeacherById(int id) throws SQLException;

	Optional<Teacher> getTeacherByUserId(int id) throws SQLException;

	List<Course> getAssociatedCourses(Teacher teacher) throws SQLException;
}
