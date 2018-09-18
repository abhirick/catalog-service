/**
 * 
 */
package com.ftd.catalogservice.domain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftd.catalogservice.domain.product.Product;

/**
 * @author Abhishek Mallick
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	public Product findProductById(String id);
}
