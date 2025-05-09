package gr.dimitriskaitantzidis.schoolspringapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

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

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(entityManager.find(entityType, id));
    }

    public <V> List<T> findBy(SingularAttribute<T, V> field, V value, boolean ignoreCase, int page, int size) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(entityType);
        Root<T> root = query.from(entityType);

        Predicate predicate;

        if (ignoreCase && value instanceof String) {
            predicate = cb.equal(cb.lower(root.get(field.getName())), ((String) value).toLowerCase());
        } else {
            predicate = cb.equal(root.get(field), value);
        }

        query.select(root).where(predicate);

        return entityManager.createQuery(query)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
    }

    public <V> List<T> findBy(SingularAttribute<T, V> field, V value) {
        return findBy(field, value, false, 0, Integer.MAX_VALUE);
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
        Optional<T> entityOpt = findById(id);
        entityOpt.ifPresent(this::delete);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
