/**
 * 
 */
package com.ftd.catalogservice.domain.sku.service;

import java.util.List;

import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Service Interface for all Sku related functionalities. It holds methods that
 * consults the Sku Repository and performs database operations on Sku Domain.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
public interface SkuService {

	/**
	 * <p>
	 * Method that is responsible for retrieving all the Sku's from the Cassandra
	 * Repository. DB.
	 * </p>
	 * 
	 * @return <code>List<Sku></code> upon success else exception will be thrown.
	 */
	public List<Sku> getAllSkus() throws NoRecordsFoundException;

	/**
	 * <p>
	 * Method that returns Sku by querying Cassandra DB with the passed in sku Id.
	 * </p>
	 * 
	 * @param orderId
	 * @return <code>Sku </code> object upon success else
	 *         <code>NoRecordsFoundException</code> will be thrown.
	 * @throws NoRecordsFoundException
	 */
	public Sku getSku(String skuId) throws NoRecordsFoundException;

	/**
	 * <p>
	 * Method responsible for retrieving all the child sku's of a parent.
	 * </p>
	 * 
	 * @param productId
	 * @return <code>List<Sku></code> upon success else
	 *         <code>NoRecordsFoundException</code> will be thrown.
	 * @throws NoRecordsFoundException 
	 */
	public List<Sku> getSkuFromParentProduct(String productId) throws NoRecordsFoundException;

}
