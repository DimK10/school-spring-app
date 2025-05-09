package gr.dimitriskaitantzidis.schoolspringapp.dao;

import gr.dimitriskaitantzidis.schoolspringapp.model.Course;

import java.util.List;
import java.util.Optional;

public class CourseDAO extends GenericDAO<Course, Integer> {

    public CourseDAO(Class<Course> entityType) {
        super(entityType);
    }

    @Override
    public void save(Course entity) {
        super.save(entity);
    }

    @Override
    public Optional<Course> findById(Integer integer) {
        return super.findById(integer);
    }

    @Override
    public List<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Course update(Course entity) {
        return super.update(entity);
    }

    @Override
    public void delete(Course entity) {
        super.delete(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        super.deleteById(integer);
    }
}
