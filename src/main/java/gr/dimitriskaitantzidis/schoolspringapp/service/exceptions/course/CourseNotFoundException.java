package gr.dimitriskaitantzidis.schoolspringapp.service.exceptions.course;


import gr.dimitriskaitantzidis.schoolspringapp.model.Course;

public class CourseNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(Course course) {
        super("Course with id = " + course.getId() + " does no exist");
    }

}
