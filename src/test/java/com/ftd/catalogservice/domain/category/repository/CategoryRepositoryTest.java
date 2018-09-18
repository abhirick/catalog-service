/**
 * 
 */
package com.ftd.catalogservice.domain.category.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.ftd.catalogservice.domain.category.Category;
import com.ftd.catalogservice.domain.category.repository.CategoryRepository;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author rjoy2
 *
 */

public class CategoryRepositoryTest {

	@Mock
	private Category category;

	@Mock
	private CategoryRepository categoryRepositroy;

	@Before
	public void setUpMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindCategoryById() {
		String catId = "cat12345";
		when(categoryRepositroy.findCategoryById(catId)).thenReturn(category);
		assertEquals(new NoRecordsFoundException("No Category Found").toString(), category,
				categoryRepositroy.findCategoryById(catId));
	}

}
