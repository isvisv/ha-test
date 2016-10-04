package isv;

import isv.ejb.UserAddressServiceEJB;
import isv.entity.Address;
import isv.entity.City;
import isv.entity.Street;
import isv.entity.User;
import isv.renderer.NamedEntityComboitemRenderer;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;

import java.util.List;

/**
 * <p>A controller supporting <code>Add Address</code> modal dialog window.</p>
 *
 * @author isv
 * @version 1.0
 */
@VariableResolver(org.zkoss.zkplus.jndi.JndiVariableResolver.class)
public class NewAddressController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    private Window newAddressWin;

    @Wire
    private Textbox zipCodeTextBox;

    @Wire
    private Combobox citiesCombobox;

    @Wire
    private Combobox streetsCombobox;

    @Wire
    private Textbox houseTextBox;

    @Wire
    private Textbox flatTextBox;

    /**
     * <p>A user account currently selected in <code>Users</code> table of the main window.</p>
     */
    private User selectedUser;

    /**
     * <p>A {@link UserAddressServiceEJB} to be used for managing user accounts and addresses.</p>
     */
    @WireVariable("UserAddressServiceEJB")
    private UserAddressServiceEJB userAddressService;

    /**
     * <p>Constructs new <code>NewAddressController</code> instance. Gets the list of the existing cities from the
     * database.</p>
     */
    public NewAddressController() {
    }

    /**
     * <p>Initializes this controller instance after associated component is composed.</p>
     *
     * @param comp a composed component attached to this controller.
     * @throws Exception if an unexpected error occurs.
     */
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        // Initialize "City" combobox
        List<City> allCities = userAddressService.getAllCities();
        citiesCombobox.setItemRenderer(new NamedEntityComboitemRenderer());
        citiesCombobox.setModel(new ListModelList<>(allCities));

        // Initialize "Street" combobox
        streetsCombobox.setItemRenderer(new NamedEntityComboitemRenderer());

        // Get a reference to currently selected user to bound new address to
        selectedUser = ExecutionContext.getSelectedUser();
    }

    /**
     * <p>Handles the event of selecting a value from the <code>City</code> combo-box. Loads the streets for the
     * selected city from the database and updates <code>streetsCombobox</code> component accordingly.</p>
     *
     */
    @Listen("onChange = #citiesCombobox")
    @NotifyChange("streetsCombobox")
    public void changeCity() {
        Comboitem selectedItem = citiesCombobox.getSelectedItem();
        if (selectedItem != null) {
            Long cityId = selectedItem.getValue();
            List<Street> streets = userAddressService.getStreetsByCity(cityId);
            streetsCombobox.setModel(new ListModelList<>(streets));
            streetsCombobox.setSelectedItem(null);
            streetsCombobox.setValue("");
        } else {
            streetsCombobox.setModel(null);
            streetsCombobox.setSelectedItem(null);
            streetsCombobox.setValue("");
        }
    }

    /**
     * <p>Closes the <code>Add Address</code> modal dialog window.</p>
     */
    @Listen("onClick = #cancelAddressButton")
    public void close() {
        newAddressWin.detach();
    }

    /**
     * <p>Creates new address and associates it with currently selected user account.</p>
     */
    @Listen("onClick = #submitAddressButton")
    public void createAddress() {
        // TODO : Validate if possible
        City city = new City();
        city.setId(citiesCombobox.getSelectedItem().getValue());

        Street street = new Street();
        street.setId(streetsCombobox.getSelectedItem().getValue());

        Address newAddress = new Address();
        newAddress.setZipCode(zipCodeTextBox.getValue());
        newAddress.setCity(city);
        newAddress.setStreet(street);
        newAddress.setHouse(houseTextBox.getValue());
        newAddress.setFlat(flatTextBox.getValue());
        newAddress.setUserId(selectedUser.getId());

        newAddress = userAddressService.createAddress(newAddress);

        Events.sendEvent("onAddressCreated", newAddressWin, newAddress);
        Executions.getCurrent().sendRedirect("index.zul");

        newAddressWin.detach();
    }
}
