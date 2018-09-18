package com.ftd.catalogservice.domain.category.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftd.catalogservice.domain.category.Category;
import com.ftd.catalogservice.domain.category.service.CategoryService;
import com.ftd.catalogservice.domain.category.web.response.CategoryResponse;
import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.shared.CommonUtils;
import com.ftd.catalogservice.domain.shared.Response;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Controller that exposes API related to Categories. It is responsible for
 * invoking Category Services which in-turn talks to Cassandra .
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@RestController
@RequestMapping("/api/v1/catalog/category")
@CrossOrigin
public class CategoryController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommonUtils commonUtils;

	/**
	 * <p>
	 * This REST API invokes the Service Component and is responsible for returning
	 * all the Categories available in the Cassandra Repository.
	 * <p>
	 * 
	 * @return <code> ResponseEntity<Response></code> on success or else
	 *         exception will be thrown.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllCategories() throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.info("[CategoryController.getAllCategories()]");
		List<CategoryResponse> categoryResponse = new ArrayList<>();

		// ("Invoking Category Services for getting all the Categories from Cassandra.
		List<Category> categoryResults = categoryService.getAllCategories();

		for (Category category : categoryResults) {
			CategoryResponse response = CategoryResponse.builder().build();
			BeanUtils.copyProperties(response, category);
			response.setCategoryCreationDate(commonUtils.convertDateToString(category.getCreationDate()));
			categoryResponse.add(response);
		}

		return CommonUtils.successResponse("Sucessfully returned All Categories ", categoryResponse);
	}

	/**
	 * <p>
	 * API created for returning Category details for an requested Category Id.
	 * </p>
	 * 
	 * @param <code>categoryId</code>
	 * @return <code>ResponseEntity<Response></code> upon success else
	 *         <code>BadRequest</code> response will be returned.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/categoryId/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getCategoryById(@PathVariable(CommonConstants.CATEGORY_ID) String categoryId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.debug("[CategoryController.getCategoryById()] : Category Id passed in is " + categoryId);
		CategoryResponse response = CategoryResponse.builder().build();

		//Invoking Category Services for getting the Category from Cassandra.
		Category categoryResult = categoryService.getCategory(categoryId);
		BeanUtils.copyProperties(response, categoryResult);
		response.setCategoryCreationDate(commonUtils.convertDateToString(categoryResult.getCreationDate()));

		return CommonUtils.successResponse("Sucessfully returned Category for the passed in Category ", response);
	}
	
}
