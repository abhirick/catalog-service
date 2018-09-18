/**
 * 
 */
package com.ftd.catalogservice.domain.product.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.product.repository.ProductRepository;

/**
 * @author rjoy2
 *
 */

public class ProductRepositoryTest{

	@Mock
	private Product product ;
	
	@Mock
	private ProductRepository productRepository;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindProductById () {
		String productId = "pd321234";
		when(productRepository.findProductById(productId)).thenReturn(product);
		assertEquals(product, (productRepository.findProductById(productId)));
		
	}

}
