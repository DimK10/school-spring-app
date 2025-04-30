package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions;


import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

public class TeacherIdAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherIdAlreadyExistsException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " already exist");
	}

}
