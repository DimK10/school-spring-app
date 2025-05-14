package gr.dimitriskaitantzidis.schoolspringapp.dto;

import gr.dimitriskaitantzidis.schoolspringapp.enums.Record;
import gr.dimitriskaitantzidis.schoolspringapp.model.Student;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;

import java.io.Serial;
import java.io.Serializable;

public class StudentDTO implements BaseDTO<Student>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    public StudentDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Student toEntity(Record record) {
        Student student = new Student();
        student.setId(this.id);
        student.setId(record.equals(Record.CREATE) ? null : this.id);
        student.setName(this.name);
        return student;
    }

    public Student toEntity(Record record, User user) {
        Student student = this.toEntity(record);
        student.setUser(user);
        student.setName(user.getName());
        return student;
    }
}
