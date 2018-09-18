/**
 * 
 */
package com.ftd.catalogservice.domain.category.service.impl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
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

import com.ftd.catalogservice.domain.category.Category;
import com.ftd.catalogservice.domain.category.repository.CategoryRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

public class CategoryServiceTest {

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryServiceImpl categoryService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private Category category;

	private List<Category> categoryList;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		setUpCategoryEntryServiceTest();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		shutDowncategoryentoryServiceTest();
	}

	/**
	 * Shut down categoryentory service test.
	 */
	private void shutDowncategoryentoryServiceTest() {
		category = null;
		categoryList = null;
	}

	/**
	 * Setup categoryentory service test.
	 */
	private void setUpCategoryEntryServiceTest() {

		MockitoAnnotations.initMocks(this);

		// Initializing a list;
		categoryList = new ArrayList<>();

		// Creating category Object.
		category = new Category();
		category.setId(UUID.randomUUID().toString());
		category.setDisplayName("CATEGORY_A");
		category.setBrand("FTD");
		category.setType("DEFAULT");

		categoryList.add(category);

	}

	@Test
	public void test_getAllCategories_whenNoCategoryFound() throws NoRecordsFoundException {
		thrown.expect(NoRecordsFoundException.class);
		thrown.expectMessage("No Categories Found in Repository ");
		Mockito.when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
		categoryService.getAllCategories();
	}

	@Test
	public void test_getAllCategories() throws NoRecordsFoundException {
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		assertNotNull(categoryService.getAllCategories());
	}

	@Test
	public void test_getCategory_whenNoCategoryFound() throws NoRecordsFoundException {
		thrown.expect(NoRecordsFoundException.class);
		thrown.expectMessage("No Category Found in Repository with Id");
		Mockito.when(categoryRepository.findCategoryById(category.getId())).thenReturn(null);
		categoryService.getCategory(category.getId());
	}

	@Test
	public void test_getCategory() throws NoRecordsFoundException {
		Mockito.when(categoryRepository.findCategoryById(category.getId())).thenReturn(category);
		assertNotNull(categoryService.getCategory(category.getId()));
	}

}
