/**
 * 
 */
package com.ftd.catalogservice.domain.category.service;

import java.util.List;

import com.ftd.catalogservice.domain.category.Category;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Service Interface for all Category related functionalities. It holds methods
 * that consults the Category Repository and performs database operations on
 * Category Domain.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
public interface CategoryService {

	/**
	 * <p>
	 * Method that is responsible for retrieving all the categories from the
	 * Cassandra Repository. DB.
	 * </p>
	 * 
	 * @return <code>List<Category></code> upon success else exception will be
	 *         thrown.
	 * @throws NoRecordsFoundException
	 */
	public List<Category> getAllCategories() throws NoRecordsFoundException;

	/**
	 * <p>
	 * Method that returns Category by querying Cassandra DB with the passed in
	 * category Id.
	 * </p>
	 * 
	 * @param categoryId
	 * @return <code>Category</code> upon success else exception will be thrown.
	 * @throws NoRecordsFoundException
	 */
	public Category getCategory(String categoryId) throws NoRecordsFoundException;

}
