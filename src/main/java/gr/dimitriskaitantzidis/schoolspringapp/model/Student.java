package gr.dimitriskaitantzidis.schoolspringapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends BaseUserEntity {

    @Column(name = "name")
    private String name;

    @OneToMany

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
