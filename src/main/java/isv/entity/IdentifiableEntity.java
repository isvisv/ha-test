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

    /**
     * <p>Checks if this entity is equal to specified one. The equality is determined by entity IDs.</p>
     *
     * @param obj another entity to check for equality with.
     * @return <code>true</code> if this entity is equal to specified one; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        IdentifiableEntity other = (IdentifiableEntity)obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;
    }

    /**
     * <p>Gets the hash code for this entity.</p>
     *
     * @return a hash code value.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
