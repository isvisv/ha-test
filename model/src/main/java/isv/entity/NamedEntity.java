package isv.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * <p>Base class for identifiable entities which have <code>name</code> attribute.</p>
 *
 * @author isv
 * @version 1.0
 */
@MappedSuperclass
public abstract class NamedEntity extends IdentifiableEntity {

    /**
     * <p>A <code>String</code> providing the value for Name property.</p>
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * <p>Constructs new <code>NamedEntity</code> instance. This implementation does nothing.</p>
     */
    protected NamedEntity() {
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
