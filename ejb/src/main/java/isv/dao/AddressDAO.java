package isv.dao;

import isv.entity.Address;
import isv.entity.City;
import isv.entity.Street;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * <p>A DAO for managing {@link Address} entities.</p>
 *
 * @author isv
 * @version 1.0
 */

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
    public Address save(Address address) {
        return saveEntity(address);
    }

    /**
     * <p>Deletes the specified address.</p>
     *
     * @param address an address to be deleted.
     */
    public void delete(Address address) {
        deleteEntity(address);
    }

    /**
     * <p>Gets the list of all existing cities.</p>
     *
     * @return a list of existing cities.
     */
    @SuppressWarnings("unchecked")
    public List<City> getAllCities() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM City c ORDER BY c.name");
        return (List<City>) query.getResultList();
    }

    /**
     * <p>Gets the streets for the specified city.</p>
     *
     * @param cityId a city ID to get the streets for.
     * @return a list of city streets.
     */
    @SuppressWarnings("unchecked")
    public List<Street> getStreetsByCity(Long cityId) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT s FROM Street s WHERE s.cityId = :cityId ORDER BY s.name");
        query.setParameter("cityId", cityId);
        return (List<Street>) query.getResultList();
    }
}
