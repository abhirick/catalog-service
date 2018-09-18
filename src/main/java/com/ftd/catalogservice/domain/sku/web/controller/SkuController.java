package com.ftd.catalogservice.domain.sku.web.controller;

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

import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.shared.CommonUtils;
import com.ftd.catalogservice.domain.shared.Response;
import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.service.SkuService;
import com.ftd.catalogservice.domain.sku.web.response.SkuResponse;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Controller that exposes API related to Skus. It is responsible for invoking
 * Sku Services which in-turn talks to Cassandra .
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@RestController
@RequestMapping("/api/v1/catalog/sku")
@CrossOrigin
public class SkuController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SkuService skuservice;

	@Autowired
	private CommonUtils commonUtils;

	/**
	 * <p>
	 * This REST API invokes the Service Component and is responsible for returning
	 * all the Skus available in the Cassandra Repository.
	 * <p>
	 * 
	 * @return <code> ResponseEntity<Response></code> on success or else exception
	 *         will be thrown.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllSkus()
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.info("[SkuController.getAllSkus()]");
		List<SkuResponse> skuResponse = new ArrayList<>();

		List<Sku> skusResults = skuservice.getAllSkus();
		for (Sku sku : skusResults) {
			SkuResponse response = SkuResponse.builder().build();
			BeanUtils.copyProperties(response, sku);
			response.setSkuCreationDate(commonUtils.convertDateToString(sku.getCreationDate()));
			skuResponse.add(response);
		}

		return CommonUtils.successResponse("Sucessfully returned All Skus ", skuResponse);
	}

	/**
	 * <p>
	 * API created for returning Sku details for an requested Sku Id
	 * </p>
	 * 
	 * @param <code>SkuId</code>
	 * @return <code>ResponseEntity<Response></code> upon success else
	 *         <code>BadRequest</code> response will be returned.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/{skuId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getSkuById(@PathVariable(CommonConstants.SKU_ID) String skuId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.debug("[SkuController.getSkuById()] : Sku Id passed in is " + skuId);
		SkuResponse response = SkuResponse.builder().build();

		Sku skusResult = skuservice.getSku(skuId);
		BeanUtils.copyProperties(response, skusResult);
		response.setSkuCreationDate(commonUtils.convertDateToString(skusResult.getCreationDate()));

		return CommonUtils.successResponse("Sucessfully returned Sku for the passed in Sku Id ", response);
	}

	/**
	 * <p>
	 * API created for returning List of Sku for an requested Parent Product Id.
	 * </p>
	 * 
	 * @param <code>productId</code>
	 * @return <code>ResponseEntity<Response></code> upon success else
	 *         <code>BadRequest</code> response will be returned.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/parentProduct/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getSkusByProductId(@PathVariable(CommonConstants.PRODUCT_ID) String productId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.debug("[SkuController.getSkusByProductId()] : Product Id passed in is " + productId);
		List<SkuResponse> skuResponse = new ArrayList<>();

		List<Sku> skusResults = skuservice.getSkuFromParentProduct(productId);
		for (Sku sku : skusResults) {
			SkuResponse response = SkuResponse.builder().build();
			BeanUtils.copyProperties(response, sku);
			response.setSkuCreationDate(commonUtils.convertDateToString(sku.getCreationDate()));
			skuResponse.add(response);
		}
		return CommonUtils.successResponse("Sucessfully returned Sku for the passed in Product Id ", skuResponse);
	}

}
