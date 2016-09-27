package isv.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Address entity.</p>
 *
 * @author isv
 * @version 1.0
 */
@Entity
public class Address extends IdentifiableEntity implements Serializable {

    /**
     * <p>A <code>Long</code> providing the value for UserId property.</p>
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * <p>A <code>City</code> providing the value for City property.</p>
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="city_id", nullable=false, updatable=false)
    private City city;

    /**
     * <p>A <code>Street</code> providing the value for Street property.</p>
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="street_id", nullable=false, updatable=false)
    private Street street;

    /**
     * <p>A <code>String</code> providing the value for House property.</p>
     */
    @Column(name = "house", nullable = false)
    private String house;

    /**
     * <p>A <code>String</code> providing the value for Flat property.</p>
     */
    @Column(name = "flat")
    private String flat;

    /**
     * <p>A <code>String</code> providing the value for String property.</p>
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * <p>Constructs new <code>Address</code> instance. This implementation does nothing.</p>
     */
    public Address() {
    }

    /**
     * <p>Gets the UserId property.</p>
     *
     * @return a <code>Long</code> providing the value for UserId property.
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <p>Sets the UserId property.</p>
     *
     * @param userId a <code>Long</code> providing the value for UserId property.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * <p>Gets the String property.</p>
     *
     * @return a <code>String</code> providing the value for String property.
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * <p>Sets the String property.</p>
     *
     * @param zipCode a <code>String</code> providing the value for String property.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * <p>Gets the Flat property.</p>
     *
     * @return a <code>String</code> providing the value for Flat property.
     */
    public String getFlat() {
        return this.flat;
    }

    /**
     * <p>Sets the Flat property.</p>
     *
     * @param flat a <code>String</code> providing the value for Flat property.
     */
    public void setFlat(String flat) {
        this.flat = flat;
    }

    /**
     * <p>Gets the House property.</p>
     *
     * @return a <code>String</code> providing the value for House property.
     */
    public String getHouse() {
        return this.house;
    }

    /**
     * <p>Sets the House property.</p>
     *
     * @param house a <code>String</code> providing the value for House property.
     */
    public void setHouse(String house) {
        this.house = house;
    }

    /**
     * <p>Gets the Street property.</p>
     *
     * @return a <code>Street</code> providing the value for Street property.
     */
    public Street getStreet() {
        return this.street;
    }

    /**
     * <p>Sets the Street property.</p>
     *
     * @param street a <code>Street</code> providing the value for Street property.
     */
    public void setStreet(Street street) {
        this.street = street;
    }

    /**
     * <p>Gets the City property.</p>
     *
     * @return a <code>City</code> providing the value for City property.
     */
    public City getCity() {
        return this.city;
    }

    /**
     * <p>Sets the City property.</p>
     *
     * @param city a <code>City</code> providing the value for City property.
     */
    public void setCity(City city) {
        this.city = city;
    }
}
