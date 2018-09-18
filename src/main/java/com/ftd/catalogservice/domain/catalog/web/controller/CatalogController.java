package com.ftd.catalogservice.domain.catalog.web.controller;

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

import com.ftd.catalogservice.domain.catalog.Catalog;
import com.ftd.catalogservice.domain.catalog.service.CatalogService;
import com.ftd.catalogservice.domain.catalog.web.response.CatalogResponse;
import com.ftd.catalogservice.domain.shared.CommonConstants;
import com.ftd.catalogservice.domain.shared.CommonUtils;
import com.ftd.catalogservice.domain.shared.Response;
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
@RestController
@RequestMapping("/api/v1/catalog")
@CrossOrigin
public class CatalogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CatalogService catalogService;

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
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllCatalogs()
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.info("[CatalogController.getAllCatalogs()]");
		List<CatalogResponse> catalogResponse = new ArrayList<>();

		List<Catalog> catalogResults = catalogService.getAllCatalogs();
		for (Catalog catalog : catalogResults) {
			CatalogResponse response = CatalogResponse.builder().build();
			BeanUtils.copyProperties(response, catalog);
			response.setCatalogCreationDate(commonUtils.convertDateToString(catalog.getCreationDate()));
			catalogResponse.add(response);
		}

		return CommonUtils.successResponse("Sucessfully returned All Catalogs ", catalogResponse);
	}

	/**
	 * <p>
	 * API created for returning Catalog details for an requested Catalog Id
	 * </p>
	 * 
	 * @param <code>CatalogId</code>
	 * @return <code>ResponseEntity<Response></code> upon success else
	 *         <code>BadRequest</code> response will be returned.
	 * @throws NoRecordsFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "/{catalogId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getCatalogById(@PathVariable(CommonConstants.CATALOG_ID) String catalogId)
			throws NoRecordsFoundException, IllegalAccessException, InvocationTargetException {

		logger.debug("[CatalogController.getCatalogById()] : Catalog Id passed in is " + catalogId);
		CatalogResponse response = CatalogResponse.builder().build();

		Catalog catalogResult = catalogService.getCatalog(catalogId);
		BeanUtils.copyProperties(response, catalogResult);
		return CommonUtils.successResponse("Sucessfully returned Catalog for the passed in Catalog ", response);
	}

}
