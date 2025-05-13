package gr.dimitriskaitantzidis.schoolspringapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import gr.dimitriskaitantzidis.schoolspringapp.model.Student;
import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import gr.dimitriskaitantzidis.schoolspringapp.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;


public class UserDTO implements BaseDTO<User>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonProperty
    private int userId;

    @NotBlank
    @JsonProperty
    private String username;

    @NotBlank
    @Email
    @JsonProperty
    private String email;

    @NotBlank // TODO add custom validation with custom annotation @ValidRole
    @JsonProperty
    private String role;

    @NotBlank
    @JsonProperty
    private String name;

    @NotBlank
    @JsonProperty
    private TeacherDTO teacherDTO;

    @NotBlank
    @JsonProperty
    private StudentDTO studentDTO;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    @Override
    public User toEntity() {
        User user = new User();
        user.setId(userId);
        user.setUserName(username);
        user.setEmail(email);

        Role userRole = Role.valueOf(role);
        user.setRole(userRole);

        Teacher teacher = this.teacherDTO.toEntity();
        user.setTeacher(teacher);

        Student student = this.studentDTO.toEntity();
        user.setStudent(student);

        return user;
    }
}
