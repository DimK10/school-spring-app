package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.enums.Role;
import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class Users extends BaseEntity {

    @Column(name = "user_name", unique = true, nullable = false)
    @Basic(optional = false)
    private String userName;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
