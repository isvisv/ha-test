package isv.services.impl;

import isv.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * <p>A DAO for managing {@link User} entities.</p>
 *
 * @author isv
 * @version 1.0
 */
@Repository
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
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> queryAll() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }
}