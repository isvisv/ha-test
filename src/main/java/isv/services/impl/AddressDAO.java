package isv.services.impl;

import isv.entity.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * <p>A DAO for managing {@link Address} entities.</p>
 *
 * @author isv
 * @version 1.0
 */
@Repository
public class AddressDAO extends AbstractDAO<Address> {

    /**
     * <p>Constructs new <code>AddressDAO</code> instance. This implementation does nothing.</p>
     */
    public AddressDAO() {
        super(Address.class);
    }

    /**
     * <p>Gets all existing address entities.</p>
     *
     * @return a {@link List} listing the found address entities.
     */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Address> queryByUserId(Long userId) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT a FROM Address a WHERE a.userId = :userId");
        query.setParameter("userId", userId);
        return (List<Address>) query.getResultList();
    }
}
