package gr.dimitriskaitantzidis.teachersspringapp.service.exceptions;


import gr.dimitriskaitantzidis.teachersspringapp.model.Teacher;

public class TeacherNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " does no exist");
	}

}
