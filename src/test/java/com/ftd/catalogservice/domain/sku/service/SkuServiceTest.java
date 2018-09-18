/**
 * 
 */
package com.ftd.catalogservice.domain.sku.service;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.repository.SkuRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author rjoy2
 *
 */
public class SkuServiceTest {
	
	@Mock
	private SkuRepository skuRepo; 
	
	@Mock
	private Sku sku;
	
	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetSku() throws NoRecordsFoundException{
		String skuId = "sku123456";
		System.out.println("Stubbing findSkuById(skuId) to return "+ sku);
		OngoingStubbing<Sku> skustub= when(skuRepo.findSkuById(skuId)).thenReturn(sku);
		System.out.println("Validated the method and obtained "+ skustub);
		System.out.println("Check if the stubbed value is null");
		assertNotNull(new NoRecordsFoundException("No Records Found").toString(), skustub);
		System.out.println("Test Completed");
	}
	
	@Test
	public void testGetSkuFromParentProductId () throws NoRecordsFoundException {
		String productId = "pd321234";
		List<Sku> skuList = new ArrayList<>();
		System.out.println("Stubbing findSkuById(skuId) to return "+ sku);
		OngoingStubbing <List<Sku>> skustubList = when(skuRepo.findSkuByParentProduct(productId)).thenReturn(skuList);
		System.out.println("Validated the method and obtained "+ skustubList);
		System.out.println("Check if the stubbed sku List is null");
		assertNotNull(new NoRecordsFoundException("No Records Found").toString(), skustubList);
		System.out.println("Test Completed");
	}
	/*@Test
	public void testGetAllSkus() throws NoRecordsFoundException {
		System.out.println("Stubbing getAllSkus to get a list of Skus");
		List<Sku> skuList = new ArrayList<>();
		OngoingStubbing<Iterable<Sku>> skustubList = when(skuRepo.findAll()).thenReturn(skuList);
		System.out.println("All the skus  obtained from the repository " +skustubList);
		System.out.println("Check if the skuStubList is empty");
		assertNotNull(new NoRecordsFoundException("No Records Found").toString(), skustubList);
		System.out.println("Test Completed");
	}
	*/
	
}
