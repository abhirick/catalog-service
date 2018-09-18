/**
 * 
 */
package com.ftd.catalogservice.domain.product.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.product.repository.ProductRepository;
import com.ftd.catalogservice.domain.product.service.ProductService;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author Abhishek Mallick
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Cacheable(value = "product")
	public List<Product> getAllProducts() throws NoRecordsFoundException {

		logger.debug("[ProductServiceImpl.getAllProducts()]");
		List<Product> queriedProducts = (List<Product>) productRepository.findAll();

		if (queriedProducts.isEmpty())
			throw new NoRecordsFoundException("No Products Found in Repository ");

		return queriedProducts;
	}

	@Override
	@Cacheable(value = "product", key = "#productId")
	public Product getProduct(String productId) throws NoRecordsFoundException {

		logger.debug("[ProductServiceImpl.getProduct()] , Product Id Passed is ::" + productId);
		Product queriedProduct = productRepository.findProductById(productId);

		if (null == queriedProduct)
			throw new NoRecordsFoundException("No Product Found in Repository with Id : " + productId);

		return queriedProduct;
	}

}
