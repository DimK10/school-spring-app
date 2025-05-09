package gr.dimitriskaitantzidis.schoolspringapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public abstract class GenericDAO<T, ID> {

    private final Class<T> entityType;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericDAO(Class<T> entityType) {
        this.entityType = entityType;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T findById(ID id) {
        return entityManager.find(entityType, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityType.getSimpleName(), entityType)
                .getResultList();
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
