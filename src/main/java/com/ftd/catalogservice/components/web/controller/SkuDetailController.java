package com.ftd.catalogservice.components.web.controller;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.service.SkuService;
import com.ftd.catalogservice.domain.sku.web.response.SkuResponse;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * <p>
 * Controller that exposes API related to Catalogs. It is responsible for
 * invoking Catalog Services which in-turn talks to Cassandra .
 * </p>
 * 
 * @author sapient
 *
 */
@Controller
public class SkuDetailController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SkuService skuService;

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
	@RequestMapping(value = "/skudetail/{skuId}", method = RequestMethod.GET)
	public String getSkuById(Model model,@PathVariable(CommonConstants.SKU_ID) String skuId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {
		System.out.println("inside getSkuId");
		logger.debug("[SkuDetailController.getSkuById()] : Sku Id passed in is " + skuId);
		SkuResponse response = SkuResponse.builder().build();

		// ("Invoking Sku Services for getting the Sku from Cassandra.
		Sku skusResults = skuService.getSku(skuId);
		BeanUtils.copyProperties(response, skusResults);
		model.addAttribute("skuResponse", response);
		return "skuDetails";
	}


}
