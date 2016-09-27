package isv.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Street entity.</p>
 *
 * @author isv
 * @version 1.0
 */
@Entity
public class Street extends IdentifiableEntity implements Serializable {

    /**
     * <p>A <code>String</code> providing the value for Name property.</p>
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * <p>A <code>Long</code> providing the value for CityId property.</p>
     */
    @Column(nullable = false)
    private Long cityId;

    /**
     * <p>Constructs new <code>Street</code> instance. This implementation does nothing.</p>
     */
    public Street() {
    }

    /**
     * <p>Gets the CityId property.</p>
     *
     * @return a <code>Long</code> providing the value for CityId property.
     */
    public Long getCityId() {
        return this.cityId;
    }

    /**
     * <p>Sets the CityId property.</p>
     *
     * @param cityId a <code>Long</code> providing the value for CityId property.
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
