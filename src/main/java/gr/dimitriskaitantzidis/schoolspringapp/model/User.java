package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import jakarta.persistence.*;

@Table(name = "users")
@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name = "User.getAllUsersOrderByNameNative"
                , query = "select u.id, " +
                "       u.user_name userName, " +
                "       u.email, " +
                "       u.role, " +
                "       case role " +
                "           when 'ROLE_TEACHER' THEN (select CONCAT(Firstname, ' ', Surname) from teachers t where u.id = t.U_id) " +
                "           when 'ROLE_STUDENT' THEN (select Name from students s where u.id = s.U_id) " +
                "           ELSE '-' END name " +
                "from users u " +
                "order by Name", resultSetMapping = "UserDTOSelectAllMapping")
})

@SqlResultSetMappings({
        @SqlResultSetMapping(name = "UserDTOSelectAllMapping", classes = {
                @ConstructorResult(
                        targetClass = UserDTO.class
                        , columns = {
                        @ColumnResult(name = "id", type = Integer.class)
                        , @ColumnResult(name = "userName", type = String.class)
                        , @ColumnResult(name = "email", type = String.class)
                        , @ColumnResult(name = "role", type = String.class)
                        , @ColumnResult(name = "name", type = String.class)
                }
                )})
})
public class User extends BaseEntity {

    @Column(name = "user_name", unique = true, nullable = false)
    @Basic(optional = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    @Basic(optional = false)
    private String email;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private Role role;


    @Transient // Will not be used with connection to db
    private Teacher teacher;

    @Transient // Will not be used with connection to db
    private Student student;

    // todo add audit properties

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
