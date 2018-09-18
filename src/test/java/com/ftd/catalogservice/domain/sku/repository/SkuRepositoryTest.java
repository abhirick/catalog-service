/**
 * 
 */
package com.ftd.catalogservice.domain.sku.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.repository.SkuRepository;

/**
 * @author rjoy2
 * The below test class validates the findByProduct and findBySkuId methods .
 *
 */

public class SkuRepositoryTest {
	
	@Mock
	private SkuRepository skuRepository;
	
	@Mock
	private Sku sku;
	
	@Mock
	private Product product;
	
	@Mock
	private List<Sku> skuList;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(skuRepository);
		assertNotNull(sku);
		assertNotNull(product);
		assertNotNull(skuList);
	}
	@Test
	public void whenFindSKUByProduct_ReturnSkuList() {
		when(skuRepository.findSkuByParentProduct(product.getId())).thenReturn(skuList);
		assertEquals(skuList, skuRepository.findSkuByParentProduct(product.getId()));
	}
	@Test
	public void whenFindSkuById_ReturnSku() {
		when(skuRepository.findSkuById(sku.getId())).thenReturn(sku);
		assertEquals(sku, skuRepository.findSkuById(sku.getId()));
	}
}
