package isv.renderer;

import isv.entity.NamedEntity;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

/**
 * <p>A renderer for combobox items represented by {@link NamedEntity} objects.</p>
 *
 * @author isv
 * @version 1.0
 */
public class NamedEntityComboitemRenderer implements ComboitemRenderer<NamedEntity> {

    /**
     * <p>Constructs new <code>NamedEntityComboitemRenderer</code> instance. This implementation does nothing.</p>
     */
    public NamedEntityComboitemRenderer() {
    }

    /**
     * Renders the data to the specified combobox item.
     *
     * @param item  the comboitem to render the result.
     * @param data  that is returned from {@link org.zkoss.zul.ListModel#getElementAt(int)}
     * @param index the index of the data that is currently being rendered
     */
    @Override
    public void render(Comboitem item, NamedEntity data, int index) throws Exception {
        item.setLabel(data.getName());
        item.setValue(data.getId());
    }
}
