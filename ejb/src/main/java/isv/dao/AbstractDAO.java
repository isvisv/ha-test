package isv.dao;

import isv.entity.IdentifiableEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * A base class for DAOs used for managing persistent entities in data store.
 *
 * @param <T> the type of the managed entities.
 * @author isv
 * @version 1.0
 */
abstract class AbstractDAO<T extends IdentifiableEntity> {

    /**
     * <p>An {@link EntityManager} to be used for accessing the persistent data store.</p>
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * <p>A {@link Class} specifying the type of the managed entities.</p>
     */
    private Class<T> entityClass;

    /**
     * <p>Constructs new <code>AbstractDAO</code> instance to manage the entities of specified type.</p>
     *
     * @param entityClass a {@link Class} specifying the type of the managed entities.
     */
    protected AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * <p>Gets the entity manager.</p>
     *
     * @return an entity manager.
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * <p>Gets the entity referenced by the specified ID.</p>
     *
     * @param id a {@link Long} providing ID referencing the entity.
     * @return an entity matching the specified ID or <code>null</code> if there is no such entity.
     */
    protected T get(Long id) {
        return em.find(entityClass, id);
    }

    /**
     * <p>Updates the specified entity.</p>
     *
     * @param entity an entity to be updated.
     * @return updated entity.
     */
    protected T saveEntity(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    /**
     * <p>Deletes the specified entity.</p>
     *
     * @param entity an entity to be deleted.
     */
    protected void deleteEntity(T entity) {
        T r = get(entity.getId());
        if (r != null) {
            em.remove(r);
        }
    }
}
