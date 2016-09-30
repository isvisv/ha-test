package isv.dao;

import isv.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * <p>A DAO for managing {@link User} entities.</p>
 *
 * @author isv
 * @version 1.0
 */
public class UserDAO extends AbstractDAO<User> {

    /**
     * <p>Constructs new <code>UserDAO</code> instance. This implementation does nothing.</p>
     */
    public UserDAO() {
        super(User.class);
    }

    /**
     * <p>Gets all existing user entities.</p>
     *
     * @return a {@link List} listing the found user entities.
     */
    @SuppressWarnings("unchecked")
    public List<User> queryAll() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }

    /**
     * <p>Updates the specified user account.</p>
     *
     * @param user an user account to be updated.
     * @return updated user account.
     */
    public User save(User user) {
        return saveEntity(user);
    }

    /**
     * <p>Deletes the specified user account.</p>
     *
     * @param user an user account to be deleted.
     */
    public void delete(User user) {
        deleteEntity(user);
    }
}