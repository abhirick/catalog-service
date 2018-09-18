/**
 * 
 */
package com.ftd.catalogservice.domain.product.service;

import java.util.List;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 ** <p>
 * Service Interface for all Product related functionalities. It holds methods
 * that consults the Product Repository and performs database operations on
 * Product Domain.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
public interface ProductService {

	/**
	 * <p>
	 * Method that is responsible for retrieving all the products from the Cassandra
	 * Repository. DB.
	 * </p>
	 * 
	 * @return <code>List<Product></code> upon success else exception will be
	 *         thrown.
	 * @throws NoRecordsFoundException
	 */
	public List<Product> getAllProducts() throws NoRecordsFoundException;

	/**
	 * <p>
	 * Method that returns Product by querying Cassandra DB with the passed in
	 * product Id.
	 * </p>
	 * 
	 * @param orderId
	 * @return Order object upon success else <code>NoRecordsFoundException</code>
	 *         will be thrown.
	 * @throws NoRecordsFoundException
	 */
	Product getProduct(String productId) throws NoRecordsFoundException;

}
