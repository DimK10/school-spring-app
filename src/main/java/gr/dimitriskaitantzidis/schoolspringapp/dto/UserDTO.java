package gr.dimitriskaitantzidis.schoolspringapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Record;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
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

    @NotBlank
    @JsonProperty
    private String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public String getRoleLabel() {
        return Role.valueOf(role).getAbbreviated();
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User toEntity(Record record) {
        User user = new User();
        user.setId(record.equals(Record.CREATE) ? null : userId);
        user.setUserName(username);
        user.setEmail(email);
        user.setName(name);

        Role userRole = Role.valueOf(role);
        user.setRole(userRole);

//        Teacher teacher = this.teacherDTO.toEntity();
//        user.setTeacher(teacher);
//
//        Student student = this.studentDTO.toEntity();
//        user.setStudent(student);

        return user;
    }
}
