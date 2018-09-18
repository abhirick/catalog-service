/**
 * 
 */
package com.ftd.catalogservice.domain.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftd.catalogservice.domain.catalog.Catalog;

/**
 * @author Abhishek Mallick
 *
 */

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, String> {

	public Catalog findCatalogById(String id);

}
