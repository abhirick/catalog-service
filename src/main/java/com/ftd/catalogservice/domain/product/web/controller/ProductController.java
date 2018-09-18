package com.ftd.catalogservice.domain.product.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftd.catalogservice.domain.product.Product;
import com.ftd.catalogservice.domain.product.service.ProductService;
import com.ftd.catalogservice.domain.product.web.response.ProductResponse;
import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.shared.CommonUtils;
import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.service.SkuService;
import com.ftd.catalogservice.domain.sku.web.response.SkuResponse;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Controller that exposes API related to Products. It is responsible for
 * invoking Product Services which in-turn talks to Cassandra .
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@RestController
@RequestMapping("/api/v1/catalog/product")
@CrossOrigin
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SkuService skuservice;

	@Autowired
	private CommonUtils commonUtils;

	/**
	 * <p>
	 * This REST API invokes the Service Component and is responsible for returning
	 * all the Products available in the Cassandra Repository.
	 * 
	 * @PreAuthorize is suitable for verifying authorization before entering into
	 *               method. 
	 * @PreAuthorize can take into account, the roles/permissions of logged-in User, argument passed to the
	 *               method etc.
	 *               <p>
	 * 
	 * @return <code>List<ProductResponse></code> on success or else exception
	 *         will be thrown.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductResponse> getAllProducts() throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.info("[ProductController.getAllProducts()]");
		List<ProductResponse> productResponse = new ArrayList<>();

		List<Product> productsResults = productService.getAllProducts();

		for (Product product : productsResults) {
			ProductResponse response = ProductResponse.builder().build();
			BeanUtils.copyProperties(response, product);
			response.setProductCreationDate(commonUtils.convertDateToString(product.getCreationDate()));
			productResponse.add(response);
		}
		return productResponse;
	}

	/**
	 * <p>
	 * API created for returning Product details for an requested Product Id
	 * </p>
	 * 
	 * @param <code>productId</code>
	 * @return <code>ResponseEntity<Response></code> upon success else
	 *         <code>BadRequest</code> response will be returned.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getProductById(@PathVariable(CommonConstants.PRODUCT_ID) String productId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.debug("[ProductController.getProductById()] : Product Id passed in is " + productId);
		ProductResponse response = ProductResponse.builder().build();

		Product productsResult = productService.getProduct(productId);
		BeanUtils.copyProperties(response, productsResult);
		response.setProductCreationDate(commonUtils.convertDateToString(productsResult.getCreationDate()));
		response.setSkuList(populateChildSkuList(productId));
		return response;
	}

	/**
	 * 
	 * @param childSKUs
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private List<SkuResponse> populateChildSkuList(String productId) throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		List<SkuResponse> skuResponse = new ArrayList<>();

		List<Sku> skusResults = skuservice.getSkuFromParentProduct(productId);
		for (Sku sku : skusResults) {
			SkuResponse response = SkuResponse.builder().build();
			BeanUtils.copyProperties(response, sku);
			skuResponse.add(response);
		}
		return skuResponse;
	}

}
