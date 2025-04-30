package gr.dimitriskaitantzidis.schoolspringapp.repository;

import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;
import org.hibernate.annotations.processing.Find;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    @Find
    public List<Teacher> findAllByOrderBySnameAscFnameAsc();
}
