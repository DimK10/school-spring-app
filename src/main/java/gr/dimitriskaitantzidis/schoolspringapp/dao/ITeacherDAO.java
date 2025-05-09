package gr.dimitriskaitantzidis.schoolspringapp.dao;


import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface ITeacherDAO {
	//	void insert(Teacher teacher) throws SQLException;
//	void delete(Teacher teacher) throws SQLException;
//	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
//	List<Teacher> getAllTeachersOrderByLnameFname() throws SQLException;
//	List<Teacher> getTeachersBySurname(String surname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;

	List<Course> getAssociatedCourses(Teacher teacher) throws SQLException;
}
