package isv;

import isv.entity.User;
import isv.services.UserAddressService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
 * <p>A controller supporting <code>Add User</code> modal dialog window.</p>
 *
 * @author isv
 * @version 1.0
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class NewUserController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    private Window newUserWin;

    @Wire
    private Textbox lastNameTextBox;

    @Wire
    private Textbox firstNameTextBox;

    @Wire
    private Textbox secondNameTextBox;

    @Wire
    private Textbox phoneTextBox;

    /**
     * <p>A {@link UserAddressService} to be used for managing user accounts and addresses/</p>
     */
    @WireVariable
    private UserAddressService userAddressService;

    /**
     * <p>Closes the <code>Add User</code> modal dialog window.</p>
     */
    @Listen("onClick = #cancelUserButton")
    public void close() {
        newUserWin.detach();
    }

    /**
     * <p>Closes the <code>Add User</code> modal dialog window.</p>
     */
    @Listen("onClick = #submitUserButton")
    public void createUser() {
        User newUser = new User();
        newUser.setLastName(lastNameTextBox.getValue());
        newUser.setFirstName(firstNameTextBox.getValue());
        newUser.setSecondName(secondNameTextBox.getValue());
        newUser.setPhone(phoneTextBox.getValue());

        newUser = userAddressService.createUser(newUser);

        Events.sendEvent("onUserCreated", newUserWin, newUser);

        newUserWin.detach();
    }
}