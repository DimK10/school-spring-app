package gr.dimitriskaitantzidis.schoolspringapp.model;

import gr.dimitriskaitantzidis.schoolspringapp.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
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
