/**
 * 
 */
package com.ftd.catalogservice.domain.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftd.catalogservice.domain.category.Category;

/**
 * @author Abhishek Mallick
 *
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

	public Category findCategoryById(String id);

}
