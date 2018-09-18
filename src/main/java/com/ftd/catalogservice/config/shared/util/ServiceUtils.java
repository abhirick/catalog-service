/**
 * 
 */
package com.ftd.catalogservice.config.shared.util;

import java.net.URI;

/**
 * @author Abhishek Mallick
 *
 */
public interface ServiceUtils {

	/**
	 *
	 * @param serviceId
	 * @return
	 */
	public URI getServiceUrl(String serviceId);

	/**
	 * <p>
	 * Method responsible for generating service url after consulting Eureka based
	 * on the service id.
	 * </p>
	 * 
	 * @param serviceId
	 * @param fallbackUri
	 * @return <code>URI</code>
	 */
	public URI getServiceUrl(String serviceId, String fallbackUri);

}
