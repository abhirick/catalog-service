/**
 * 
 */
package com.ftd.catalogservice.domain.catalog.service;

import java.util.List;

import com.ftd.catalogservice.domain.catalog.Catalog;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Service Interface for all Catalog related functionalities. It holds methods
 * that consults the Catalog Repository and performs database operations on
 * Catalog Domain.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
public interface CatalogService {

	/**
	 * <p>
	 * Method that is responsible for retrieving all the catalogs from the Cassandra
	 * Repository. DB.
	 * </p>
	 * 
	 * @return <code>List<catalog></code> upon success else exception will be
	 *         thrown.
	 * @throws NoRecordsFoundException
	 */
	public List<Catalog> getAllCatalogs() throws NoRecordsFoundException;

	/**
	 * <p>
	 * Method that returns catalog by querying Cassandra DB with the passed in
	 * catalog Id.
	 * </p>
	 * 
	 * @param categorId
	 * @return <code>catalog</code> upon success else exception will be thrown.
	 * @throws NoRecordsFoundException
	 */
	public Catalog getCatalog(String catalogId) throws NoRecordsFoundException;

}
