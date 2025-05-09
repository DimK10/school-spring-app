package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.course;


import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

public class CourseIdAlreadyExistsException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CourseIdAlreadyExistsException(Teacher teacher) {
        super("Course with id = " + teacher.getId() + " already exist");
    }

}
