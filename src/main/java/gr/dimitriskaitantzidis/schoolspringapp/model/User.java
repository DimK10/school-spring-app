package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import jakarta.persistence.*;

@Table(name = "users")
@Entity
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
}
