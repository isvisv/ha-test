/*
 * Copyright (C) 2016 TopCoder Inc., All Rights Reserved.
 */
package isv.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <p>Base class for entities identified with unique numeric IDs.</p>
 *
 * @author isv
 * @version 1.0
 */
@MappedSuperclass
public abstract class IdentifiableEntity {

    /**
     * <p>A <code>Long</code> providing the value for Id property.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * <p>Constructs new <code>IdentifiableEntity</code> instance. This implementation does nothing.</p>
     */
    protected IdentifiableEntity() {
    }

    /**
     * <p>Gets the Id property.</p>
     *
     * @return a <code>Long</code> providing the value for Id property.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <p>Sets the Id property.</p>
     *
     * @param id a <code>Long</code> providing the value for Id property.
     */
    public void setId(Long id) {
        this.id = id;
    }
}
