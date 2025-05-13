package gr.dimitriskaitantzidis.schoolspringapp.dto;

import gr.dimitriskaitantzidis.schoolspringapp.model.Student;

import java.io.Serial;
import java.io.Serializable;

public class StudentDTO implements BaseDTO<Student>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    @Override
    public Student toEntity() {
        Student student = new Student();
        student.setId(this.id);
        student.setName(this.name);
        return student;
    }
}
