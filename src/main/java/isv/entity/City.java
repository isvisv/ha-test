package isv.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>City entity.</p>
 *
 * @author isv
 * @version 1.0
 */
@Entity
public class City extends IdentifiableEntity implements Serializable {

    /**
     * <p>A <code>String</code> providing the value for Name property.</p>
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * <p>Constructs new <code>City</code> instance. This implementation does nothing.</p>
     */
    public City() {
    }

    /**
     * <p>Gets the Name property.</p>
     *
     * @return a <code>String</code> providing the value for Name property.
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>Sets the Name property.</p>
     *
     * @param name a <code>String</code> providing the value for Name property.
     */
    public void setName(String name) {
        this.name = name;
    }
}
