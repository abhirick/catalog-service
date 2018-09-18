/**
 * 
 */
package com.ftd.catalogservice.config.shared.util.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import com.ftd.catalogservice.config.shared.util.ServiceUtils;

/**
 * @author Abhishek Mallick
 *
 */
@Component
public class ServiceUtilsImpl implements ServiceUtils {

	private static final Logger log = LoggerFactory.getLogger(ServiceUtilsImpl.class);

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Override
	public URI getServiceUrl(String serviceId) {
		return getServiceUrl(serviceId, null);
	}

	@Override
	public URI getServiceUrl(String serviceId, String fallbackUri) {

		log.debug("[ServiceUtilsImpl.getServiceUrl()]: Service Id & Fallback Uri Passed in " + serviceId, fallbackUri);
		URI uri = null;
		try {
			ServiceInstance instance = loadBalancer.choose(serviceId);
			if (instance == null) {
				throw new RuntimeException("Can't find a service with serviceId = " + serviceId);
			}
			uri = instance.getUri();
			log.debug("Resolved serviceId '{}' to URL '{}'.", serviceId, uri);

		} catch (RuntimeException e) {
			// Eureka not available, use fallback if specified otherwise rethrow the error.
			if (fallbackUri == null) {
				throw e;

			} else {
				uri = URI.create(fallbackUri);
				log.warn("Failed to resolve serviceId '{}'. Fallback to URL '{}'.", serviceId, uri);
			}
		}
		return uri;
	}

}
