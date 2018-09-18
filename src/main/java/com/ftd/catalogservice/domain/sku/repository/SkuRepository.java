/**
 * 
 */
package com.ftd.catalogservice.domain.sku.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftd.catalogservice.domain.sku.Sku;

/**
 * @author Abhishek Mallick
 *
 */

@Repository
public interface SkuRepository extends JpaRepository<Sku, String> {

	public List<Sku> findSkuByParentProduct(String skuId);

	public Sku findSkuById(String skuId);

}
