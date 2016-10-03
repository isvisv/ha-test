package isv.ejb;

import isv.dao.AddressDAO;
import isv.dao.UserDAO;
import isv.entity.Address;
import isv.entity.User;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>A stateless EJB providing interface to User Address service</p>
 *
 * @author isv
 * @version 1.0
 */
@Stateless(mappedName = "java:comp/env/UserAddressServiceEJB", name="UserAddressServiceEJB")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserAddressServiceEJB {

    /**
     * <p>A {@link UserDAO} to be used for managing the user accounts.</p>
     */
    @Inject
    private UserDAO userDAO;

    /**
     * <p>A {@link AddressDAO} to be used for managing the user addresses.</p>
     */
    @Inject
    private AddressDAO addressDAO;

    /**
     * <p>Constructs new <code>UserAddressServiceEJB</code> instance. This implementation does nothing.</p>
     */
    public UserAddressServiceEJB() {
    }

    /**
     * <p>Gets all existing users.</p>
     *
     * @return a {@link List} listing the user accounts or empty list if there are no user accounts.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<User> getUsers() {
        List<User> users = this.userDAO.queryAll();
        if (users == null) {
            users = new ArrayList<User>();
        }
        return users;
    }

    /**
     * <p>Gets all addresses mapped to specified user.</p>
     *
     * @param userId a {@link Long} providing the ID referencing the user.
     * @return a {@link List} listing the addresses for user.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Address> getUserAddresses(Long userId) {
        return this.addressDAO.queryByUserId(userId);
    }

    /**
     * <p>Deletes specified user account.</p>
     *
     * @param user a {@link User} representing the user.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteUser(User user){
        this.addressDAO.deleteByUserId(user.getId());
        this.userDAO.delete(user);
    }

    /**
     * <p>Deletes specified address.</p>
     *
     * @param address a {@link Address} representing the address.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteAddress(Address address) {
        this.addressDAO.delete(address);
    }

    /**
     * <p>Creates new user account.</p>
     *
     * @param newUser a new user account to be created.
     * @return created user account.
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public User createUser(User newUser) {
        return this.userDAO.save(newUser);
    }

}
