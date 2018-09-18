package com.ftd.catalogservice.components.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.product.service.ProductService;
import com.ftd.catalogservice.domain.product.web.response.ProductResponse;
import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.shared.CommonUtils;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Controller that exposes API related to Catalogs. It is responsible for
 * invoking Catalog Services which in-turn talks to Cassandra .
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@Controller
public class ProductDetailController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Autowired
	private CommonUtils commonUtils;

	/**
	 * <p>
	 * This REST API invokes the Service Component and is responsible for returning
	 * all the Catalogs available in the Cassandra Repository.
	 * <p>
	 * 
	 * @return <code> ResponseEntity<Response></code> on success or else exception
	 *         will be thrown.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/productdetail/{productId}", method = RequestMethod.GET)
	public String generateProductDetails(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable(CommonConstants.PRODUCT_ID) String productId) throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {
		System.out.println("Inside Generate productdetails");
		logger.debug("[ProductDetailController.generateProductDetails()] , Product Id Passed is ::" + productId);
		ProductResponse productResponse = ProductResponse.builder().build();
		
		// ("Invoking Product Services for getting the Product from Cassandra.
		Product productsResult = productService.getProduct(productId);
		BeanUtils.copyProperties(productResponse, productsResult);
		
		model.addAttribute("productResponse", productResponse);
		return "productdetails";
	}
	
	@RequestMapping("/productdetail/all")
	public String productdetails (Model model) throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {
		logger.info("[ProductDetailController.getAllProducts()]");
		List<ProductResponse> productResponse = new ArrayList<>();

		List<Product> productsResults = productService.getAllProducts();

		for (Product product : productsResults) {
			ProductResponse response = ProductResponse.builder().build();
			BeanUtils.copyProperties(response, product);
			productResponse.add(response);
		}
		model.addAttribute("productResponse", productResponse);
		return "productListing";
	}
	 
}
