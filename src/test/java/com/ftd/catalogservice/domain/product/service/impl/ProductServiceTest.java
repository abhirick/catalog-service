/**
 * 
 */
package com.ftd.catalogservice.domain.product.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.product.repository.ProductRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author rjoy2
 *
 */
public class ProductServiceTest {


	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private Product product;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}

/*	@Test
	public void testGetAllProducts()  {
		List<Product> productList = new ArrayList<>();
		OngoingStubbing<Iterable<Product>> productStub = when(productRepository.findAll()).thenReturn(productList);
		assertNotNull(new NoRecordsFoundException("No Products obtained").toString(), productStub);
	}*/

	@Test
	public void testGetProduct() {
		String productId = "pd321234";
		OngoingStubbing<Product> prodStub =  when(productRepository.findProductById(productId)).thenReturn(product);
		assertNotNull(new NoRecordsFoundException("Product not found").toString(), prodStub);
		assertEquals(product, productRepository.findProductById(productId));
	}

}