/**
 * 
 */
package com.ftd.catalogservice.domain.shared;

import java.io.Serializable;

/**
 * 
 * @author Abhishek Mallick
 *         <p>
 *         A Domain Entity
 *         </p>
 * 
 *
 * @param <T>
 */
public interface Entity<T> extends Serializable {

	/**
	 * Entities compare by identity, not by attributes.
	 *
	 * @param other
	 *            The other entity.
	 * @return true if the identities are the same irrespective of other attributes.
	 */
	boolean sameIdentityAs(T other);
}
