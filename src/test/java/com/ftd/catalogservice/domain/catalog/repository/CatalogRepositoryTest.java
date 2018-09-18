/**
 * 
 */
package com.ftd.catalogservice.domain.catalog.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ftd.catalogservice.domain.catalog.Catalog;
import com.ftd.catalogservice.domain.catalog.repository.CatalogRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author rjoy2
 *
 */

public class CatalogRepositoryTest  {

	@Mock
	private Catalog catalog;

	@Mock
	private CatalogRepository catalogRepository;

	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindCategoryById() {
		String catalogId = "cat12345";
		when(catalogRepository.findCatalogById(catalogId)).thenReturn(catalog);
		assertEquals(new NoRecordsFoundException("No Catalog Found").toString(), catalog,
				catalogRepository.findCatalogById(catalogId));
	}
}
