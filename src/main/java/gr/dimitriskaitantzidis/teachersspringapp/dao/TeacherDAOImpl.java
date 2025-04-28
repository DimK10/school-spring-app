package gr.dimitriskaitantzidis.teachersspringapp.dao;


import gr.dimitriskaitantzidis.teachersspringapp.model.Teacher;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeacherDAOImpl implements ITeacherDAO {

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


