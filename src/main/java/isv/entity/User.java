package isv.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>User entity.</p>
 *
 * @author isv
 * @version 1.0
 */
@Entity
@Table(name = "ha_user")
public class User extends IdentifiableEntity implements Serializable {

    /**
     * <p>A <code>String</code> providing the value for FirstName property.</p>
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * <p>A <code>String</code> providing the value for LastName property.</p>
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * <p>A <code>String</code> providing the value for SecondName property.</p>
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * <p>A <code>String</code> providing the value for Phone property.</p>
     */
    @Column(name = "phone")
    private String phone;

    /**
     * <p>Constructs new <code>User</code> instance. This implementation does nothing.</p>
     */
    public User() {
    }

    /**
     * <p>Gets the Phone property.</p>
     *
     * @return a <code>String</code> providing the value for Phone property.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * <p>Sets the Phone property.</p>
     *
     * @param phone a <code>String</code> providing the value for Phone property.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * <p>Gets the SecondName property.</p>
     *
     * @return a <code>String</code> providing the value for SecondName property.
     */
    public String getSecondName() {
        return this.secondName;
    }

    /**
     * <p>Sets the SecondName property.</p>
     *
     * @param secondName a <code>String</code> providing the value for SecondName property.
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * <p>Gets the LastName property.</p>
     *
     * @return a <code>String</code> providing the value for LastName property.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * <p>Sets the LastName property.</p>
     *
     * @param lastName a <code>String</code> providing the value for LastName property.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>Gets the FirstName property.</p>
     *
     * @return a <code>String</code> providing the value for FirstName property.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * <p>Sets the FirstName property.</p>
     *
     * @param firstName a <code>String</code> providing the value for FirstName property.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
