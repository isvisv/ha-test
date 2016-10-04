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
public class City extends NamedEntity implements Serializable {

    private static final long serialVersionUID = 3L;

    /**
     * <p>Constructs new <code>City</code> instance. This implementation does nothing.</p>
     */
    public City() {
    }
}
