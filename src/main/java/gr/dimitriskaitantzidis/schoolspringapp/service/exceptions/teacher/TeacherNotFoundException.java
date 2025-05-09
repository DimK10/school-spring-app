package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.teacher;


import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

public class TeacherNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " does no exist");
	}

}
