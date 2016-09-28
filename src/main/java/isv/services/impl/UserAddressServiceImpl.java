package isv.services.impl;

import isv.entity.Address;
import isv.entity.User;
import isv.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>A default implementation of service for managing user accounts and associated addresses.</p>
 *
 * @author isv
 * @version 1.0
 */
@Service("userAddressService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserAddressServiceImpl implements UserAddressService {

    /**
     * <p>A {@link UserDAO} to be used for managing the user accounts.</p>
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * <p>A {@link AddressDAO} to be used for managing the user addresses.</p>
     */
    @Autowired
    private AddressDAO addressDAO;

    /**
     * <p>Constructs new <code>UserAddressServiceImpl</code> instance. This implementation does nothing.</p>
     */
    public UserAddressServiceImpl() {
    }

    /**
     * <p>Gets all existing users.</p>
     *
     * @return a {@link List} listing the user accounts or empty list if there are no user accounts.
     */
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
    public List<Address> getUserAddresses(Long userId) {
        return this.addressDAO.queryByUserId(userId);
    }

    /**
     * <p>Deletes specified user account.</p>
     *
     * @param user a {@link User} representing the user.
     */
    public void deleteUser(User user){
        this.addressDAO.deleteByUserId(user.getId());
        this.userDAO.delete(user);
    }

    /**
     * <p>Deletes specified address.</p>
     *
     * @param address a {@link Address} representing the address.
     */
    public void deleteAddress(Address address) {
        this.addressDAO.delete(address);
    }
}
