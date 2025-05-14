package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "Student.findByUserId"
                , query = "select s" +
                " from Student s" +
                " left join fetch s.user u " +
                "where u.id = :userId")
})
public class Student extends BaseUserEntity {

    @Column(name = "name")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public UserDTO toUserDTO() {
        UserDTO userDTO = super.toUserDTO();
        userDTO.setName(name);
        return userDTO;
    }
}
