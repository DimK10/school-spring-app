package gr.dimitriskaitantzidis.schoolspringapp.service.impl;



import gr.dimitriskaitantzidis.schoolspringapp.dao.ITeacherDAO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.service.ITeacherService;
import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher.TeacherNotFoundException;
import gr.dimitriskaitantzidis.schoolspringapp.util.BasicValidator;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Service
public class TeacherServiceImpl implements ITeacherService {
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
//
//	@Override
//	public void insertTeacher(TeacherDTO teacherDTO)
//			throws TeacherIdAlreadyExistsException, SQLException {
//
//		Teacher newTeacher = new Teacher();
//		newTeacher.setId(teacherDTO.getId());
//		newTeacher.setSname(teacherDTO.getSname());
//		newTeacher.setFname(teacherDTO.getFname());
//
//		if ((teacherDAO.getTeacherById(newTeacher.getId())) == null)
//			teacherDAO.insert(newTeacher);
//		else {
//			throw new TeacherIdAlreadyExistsException(newTeacher);
//		}
//	}
//
//	@Override
//	public void deleteTeacher(TeacherDTO teacherDTO) throws TeacherNotFoundException, SQLException {
//		Teacher teacherToDelete = new Teacher();
//		teacherToDelete.setId(teacherDTO.getId());
//
//		if ((teacherDAO.getTeacherById(teacherToDelete.getId())) == null)
//			throw new TeacherNotFoundException(teacherToDelete);
//		teacherDAO.delete(teacherToDelete);
//
//	}
//
//	@Override
//	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws TeacherNotFoundException, SQLException {
//		Teacher teacherToUpdate = new Teacher();
//		teacherToUpdate.setId(oldTeacherDTO.getId());
//
//		Teacher newTeacher = new Teacher();
//		newTeacher.setId(newTeacherDTO.getId());
//		newTeacher.setSname(newTeacherDTO.getSname());
//		newTeacher.setFname(newTeacherDTO.getFname());
//
//		if ((teacherDAO.getTeacherById(teacherToUpdate.getId())) == null)
//			throw new TeacherNotFoundException(teacherToUpdate);
//		teacherDAO.update(teacherToUpdate, newTeacher);
//
//	}
//
//	@Override
//	public List<Teacher> getAllTeachersOrderByLnameFname() throws SQLException {
//		return this.teacherDAO.getAllTeachersOrderByLnameFname();
//	}
//
//	@Override
//	public List<Teacher> getTeachersBySurname(String surname) throws SQLException {
//		return teacherDAO.getTeachersBySurname(surname);
//	}


	@Override
	public List<Course> getAssociatedCourses(Teacher teacher) throws SQLException {
		List<Course> courses = new ArrayList<>();
		courses = teacherDAO.getAssociatedCourses(teacher);
		return courses;
	}
}
