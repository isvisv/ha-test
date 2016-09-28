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

    /**
     * <p>Deletes specified user account.</p>
     *
     * @param user a {@link User} representing the user.
     */
    void deleteUser(User user);

    /**
     * <p>Deletes specified address.</p>
     *
     * @param address a {@link Address} representing the address.
     */
    void deleteAddress(Address address);

    /**
     * <p>Creates new user account.</p>
     *
     * @param newUser a new user account to be created.
     * @return created user.
     */
    User createUser(User newUser);
}
