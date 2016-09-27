package isv.services;

import isv.entity.Address;
import isv.entity.User;

import java.util.List;

/**
 * <p>An interface for service to be used for managing data for users and their respective addresses.</p>
 *
 * @author isv
 * @version 1.0
 */
public interface UserAddressService {

    /**
     * <p>Gets all existing users.</p>
     *
     * @return a {@link List} listing the user accounts or empty list if there are no user accounts.
     */
    List<User> getUsers();

    /**
     * <p>Gets all addresses mapped to specified user.</p>
     *
     * @param userId a {@link Long} providing the ID referencing the user.
     * @return a {@link List} listing the addresses for user.
     */
    List<Address> getUserAddresses(Long userId);
}
