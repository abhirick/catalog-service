/**
 * 
 */
package com.ftd.catalogservice.domain.category.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftd.catalogservice.domain.category.Category;
import com.ftd.catalogservice.domain.category.repository.CategoryRepository;
import com.ftd.catalogservice.domain.category.service.CategoryService;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author Abhishek Mallick
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() throws NoRecordsFoundException {

		logger.debug("[CategoryServiceImpl.getAllCategories()]");
		List<Category> queriedCategories = (List<Category>) categoryRepository.findAll();

		if (queriedCategories.isEmpty())
			throw new NoRecordsFoundException("No Categories Found in Repository ");

		return queriedCategories;
	}

	@Override
	public Category getCategory(String categoryId) throws NoRecordsFoundException {

		logger.debug("[CategoryServiceImpl.getCategory()] , Category Id Passed is ::" + categoryId);
		Category queriedCategory = categoryRepository.findCategoryById(categoryId);

		if (null == queriedCategory)
			throw new NoRecordsFoundException("No Category Found in Repository with Id : " + categoryId);

		return queriedCategory;
	}

}
