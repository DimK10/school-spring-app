package gr.dimitriskaitantzidis.schoolspringapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(name = "Title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
