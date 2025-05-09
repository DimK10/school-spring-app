package gr.dimitriskaitantzidis.schoolspringapp.service;



import gr.dimitriskaitantzidis.schoolspringapp.dto.TeacherDTO;
import gr.dimitriskaitantzidis.schoolspringapp.model.Course;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher.TeacherIdAlreadyExistsException;
import gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher.TeacherNotFoundException;
import org.springframework.javapoet.ClassName;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public interface ITeacherService {

	static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	/**
	 * Inserts a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			DTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
//	void insertTeacher(TeacherDTO teacherDTO)
//			throws TeacherIdAlreadyExistsException, SQLException;
	
	/**
	 * Deletes a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param teacherDTO 
	 * 			DTO object that contains the data.
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any Teacher identified by their id 
	 * 			needed to be inserted has been already
	 * 			inserted. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */

//	void deleteTeacher(TeacherDTO teacherDTO)
//			throws TeacherNotFoundException, SQLException;
	
	
	/**
	 * Updates a {@link Teacher} based on the data carried by the
	 * {@link TeacherDTO}.
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object that contains the data -mainly the id-
	 * 			of the {@link Teacher} that will be updated.  
	 * @param newTeacherDTO
	 * 			DTO object that contains the data of the 
	 * 			new {@link Teacher}.
	 * @throws TeacherNotFoundException
	 * 			if any Teacher identified by their id 
	 * 			was not found. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
//	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
//			throws TeacherNotFoundException, SQLException;

	/**
	 * Retrieves all {@link Teacher} objects into a list
	 * @return
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
//	List<Teacher> getAllTeachersOrderByLnameFname() throws SQLException;
	
	
	/**
	 * Searches and gets back to the caller a list
	 * of the {@link Teacher} objects identified by
	 * by their surname or surname's initial letters.
	 * 
	 * @param surname
	 * 			a String object that contains the
	 * 			surname or the letters that the 
	 * 			surname starts with, of the {@link Teacher}
	 * 			objects we are looking for. 
	 * @return
	 * 			a List that contains the results of
	 * 			the search, that is a List of {@link Teacher}
	 * 			objects. 
	 * @throws SQLException
	 * 			if any error happens between the driver
	 * 			and the server.
	 */
//	List<Teacher> getTeachersBySurname(String surname)
//			throws SQLException;

	/**
	 * This method fetches the courses that are related with a teacher (courses that are being taught by them)
	 *
	 * @param teacher The {@link Teacher} entity.
	 * @return A List of {@link Course} courses.
	 * @throws SQLException If any error happens between the driver and the server.
	 */
	List<Course> getAssociatedCourses(Teacher teacher) throws SQLException;
}
