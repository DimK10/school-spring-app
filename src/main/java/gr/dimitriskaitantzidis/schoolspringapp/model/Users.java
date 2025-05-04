package gr.dimitriskaitantzidis.schoolspringapp.model;

import jakarta.persistence.*;

@Table(name = "users")
@Entity
public class Users {

    public enum Role {
        ROLE_ADMIN("ROLE_ADMIN"), ROLE_TEACHER("ROLE_TEACHER"), ROLE_STUDENT("ROLE_STUDENT");

        public final String value;

        Role(String value) {
            this.value = value;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
