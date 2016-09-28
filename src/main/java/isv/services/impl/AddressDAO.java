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

    /**
     * <p>Deletes all addresses mapped to specified user.</p>
     *
     * @param userId a {@link Long} providing the user ID.
     */
    @Transactional
    public void deleteByUserId(Long userId) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("DELETE FROM Address a WHERE a.userId = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    /**
     * <p>Updates the specified address.</p>
     *
     * @param address an address to be updated.
     * @return updated address.
     */
    @Transactional
    public Address save(Address address) {
        return saveEntity(address);
    }

    /**
     * <p>Deletes the specified address.</p>
     *
     * @param address an address to be deleted.
     */
    @Transactional
    public void delete(Address address) {
        deleteEntity(address);
    }
}
