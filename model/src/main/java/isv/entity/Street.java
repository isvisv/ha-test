package isv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * <p>Street entity.</p>
 *
 * @author isv
 * @version 1.0
 */
@Entity
public class Street extends NamedEntity implements Serializable {

    private static final long serialVersionUID = 4L;

    /**
     * <p>A <code>Long</code> providing the value for CityId property.</p>
     */
    @Column(name="city_id", nullable = false)
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

}
