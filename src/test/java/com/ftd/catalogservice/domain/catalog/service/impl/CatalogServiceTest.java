/**
 * 
 */
package com.ftd.catalogservice.domain.catalog.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ftd.catalogservice.domain.catalog.Catalog;
import com.ftd.catalogservice.domain.catalog.repository.CatalogRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * The Test Class CatalogServiceTest.
 * 
 * @author Abhishek Mallick
 */
public class CatalogServiceTest {

	/** The catalog repository. */
	@Mock
	private CatalogRepository catalogRepository;

	/** The catalog service. */
	@InjectMocks
	private CatalogServiceImpl catalogService;

	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/** The catalog. */
	private Catalog catalog;

	/** The catalog list. */
	private List<Catalog> catalogList;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		setUpCatalogEntryServiceTest();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		shutDowncatalogentoryServiceTest();
	}

	/**
	 * Shut down catalogentory service test.
	 */
	private void shutDowncatalogentoryServiceTest() {
		catalog = null;
		catalogList = null;
	}

	/**
	 * Setup catalogentory service test.
	 */
	private void setUpCatalogEntryServiceTest() {

		MockitoAnnotations.initMocks(this);

		// Initializing a list;
		catalogList = new ArrayList<>();

		// Creating catalogentory Object.
		catalog = new Catalog();
		catalog.setId(UUID.randomUUID().toString());
		catalog.setDisplayName("CATA");
		catalog.setDefaultShippingMethod("HARDGOOD");
		catalog.setType("DEFAULT");

		catalogList.add(catalog);

	}

	/**
	 * Test get all catalogs when no catalog found.
	 *
	 * @throws NoRecordsFoundException
	 *             the no records found exception
	 */
	@Test
	public void test_getAllCatalogs_whenNoCatalogFound() throws NoRecordsFoundException {
		thrown.expect(NoRecordsFoundException.class);
		thrown.expectMessage("No Catalogs Found in Repository ");
		Mockito.when(catalogRepository.findAll()).thenReturn(new ArrayList<>());
		catalogService.getAllCatalogs();
	}

	/**
	 * Test get all catalogs.
	 *
	 * @throws NoRecordsFoundException
	 *             the no records found exception
	 */
	@Test
	public void test_getAllCatalogs() throws NoRecordsFoundException {
		Mockito.when(catalogRepository.findAll()).thenReturn(catalogList);
		assertNotNull(catalogService.getAllCatalogs());
	}

	/**
	 * Test get catalog when no catalog found.
	 *
	 * @throws NoRecordsFoundException
	 *             the no records found exception
	 */
	@Test
	public void test_getCatalog_whenNoCatalogFound() throws NoRecordsFoundException {
		thrown.expect(NoRecordsFoundException.class);
		thrown.expectMessage("No Catalogs Found in Repository ");
		Mockito.when(catalogRepository.findAll()).thenReturn(new ArrayList<>());
		catalogService.getCatalog(catalog.getId());
	}

	/**
	 * Test get catalog.
	 *
	 * @throws NoRecordsFoundException
	 *             the no records found exception
	 */
	@Test
	public void test_getCatalog() throws NoRecordsFoundException {
		Mockito.when(catalogRepository.findCatalogById(catalog.getId())).thenReturn(catalog);
		assertNotNull(catalogService.getCatalog(catalog.getId()));
	}

}
