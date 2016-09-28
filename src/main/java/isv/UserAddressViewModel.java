package isv;

import isv.entity.Address;
import isv.entity.User;
import isv.services.UserAddressService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import java.util.List;

/**
 * <p>A model for <code>Users and Addresses</code> view.</p>
 *
 * @author isv
 * @version 1.0
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UserAddressViewModel {

    /**
     * <p>A {@link UserAddressService} to be used for managing user accounts and addresses/</p>
     */
    @WireVariable
    private UserAddressService userAddressService;

    /**
     * <p>A {@link ListModelList} lising the user accounts.</p>
     */
    private ListModelList<User> userListModelList;

    /**
     * <p>A {@link ListModelList} lising the addresses for selected user account.</p>
     */
    private ListModelList<Address> addressListModelList;

    /**
     * <p>A {@link User} representing the currently selected user.</p>
     */
    private User selectedUser;

    /**
     * <p>A {@link Address} representing the currently selected address.</p>
     */
    private Address selectedAddress;

    /**
     * <p>Constructs new <code>UserAddressViewModel</code> instance. This implementation does nothing.</p>
     */
    public UserAddressViewModel() {
    }

    /**
     * <p>Initializes this model instance. Gets the list of existing user accounts and selects first item from the list
     * as selected user account.</p>
     */
    @Init
    public void init() {
        loadData();
    }

    /**
     * <p>Gets the existing user accounts.</p>
     *
     * @return a {@link ListModelList} listing the user accounts.
     */
    public ListModelList<User> getUserListModelList() {
        return userListModelList;
    }

    /**
     * <p>Gets the existing addresses for selected user account.</p>
     *
     * @return a {@link ListModelList} listing the addresses for selected user account.
     */
    public ListModelList<Address> getAddressListModelList() {
        return addressListModelList;
    }

    /**
     * <p>Gets the addresses for currently selected user account.</p>
     *
     * @return a {@link Address} representing the currently selected address.
     */
    public Address getSelectedAddress() {
        return selectedAddress;
    }

    /**
     * <p>Sets the addresses for currently selected user account.</p>
     *
     * @param selectedAddress a {@link Address} representing the currently selected address.
     */
    public void setSelectedAddress(Address selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    /**
     * <p>Gets currently selected user account.</p>
     *
     * @return a {@link User} representing the currently selected user.
     */
    public User getSelectedUser() {
        return selectedUser;
    }

    /**
     * <p>Sets specified user account as currently selected. Loads the addresses for selected user.</p>
     *
     * @param selectedUser a {@link User} representing the currently selected user.
     */
    @Command
    @NotifyChange("addressListModelList")
    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
        loadSelectedUserAddresses();
    }

    /**
     * <p>Deletes specified user account</p>
     *
     * @param user a {@link User} representing the user account to be deleted.
     */
    @Command
    @NotifyChange({"userListModelList", "addressListModelList"})
    public void deleteUser(@BindingParam("user") User user) {
        userAddressService.deleteUser(user);
        loadData();
    }

    /**
     * <p>Deletes specified address</p>
     *
     * @param address a {@link Address} representing the address to be deleted.
     */
    @Command
    @NotifyChange("addressListModelList")
    public void deleteAddress(@BindingParam("address") Address address) {
        userAddressService.deleteAddress(address);
        loadSelectedUserAddresses();
    }

    /**
     * <p>Loads the data for this view model. Gets the list of user accounts and sets the first one as selected.</p>
     */
    private void loadData() {
        List<User> userList = userAddressService.getUsers();
        userListModelList = new ListModelList<User>(userList);
        if (!userList.isEmpty()) {
            setSelectedUser(userList.get(0));
        } else {
            setSelectedUser(null);
            setSelectedAddress(null);
        }
    }

    /**
     * <p>Loads the addresses for currently selected user.</p>
     */
    private void loadSelectedUserAddresses() {
        if (selectedUser != null) {
            List<Address> userAddresses = userAddressService.getUserAddresses(selectedUser.getId());
            this.addressListModelList = new ListModelList<Address>(userAddresses);
            if (!userAddresses.isEmpty()) {
                setSelectedAddress(userAddresses.get(0));
            }
        } else {
            this.addressListModelList = null;
        }
    }
}
