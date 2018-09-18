package com.ftd.catalogservice.domain.shared;

import java.io.Serializable;

/**
 * @author Abhishek Mallick
 *         <p>
 *         A value object.
 *         </p>
 * 
 */
public interface ValueObject<T> extends Serializable {

	/**
	 * <p>
	 * Value objects compare by the values of their attributes, they don't have an
	 * identity.
	 * </p>
	 *
	 * @param other  The other value object.
	 * @return <code>true</code> if the given value object's and this value object's
	 *         attributes are the same.
	 */
	boolean sameValueAs(T other);

}
