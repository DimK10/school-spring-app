package gr.dimitriskaitantzidis.schoolspringapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
@NamedQueries({
        @NamedQuery(name = "Course.findAllRelatedCourses"
                , query = "select c" +
                " from Course c" +
                " inner join fetch c.teachers t " +
                " where t.id = :teacherId")
        ,
})
public class Course extends BaseEntity {

    @Column(name = "Title")
    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
