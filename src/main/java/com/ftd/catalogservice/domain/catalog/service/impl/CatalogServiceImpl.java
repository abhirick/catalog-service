/**
 * 
 */
package com.ftd.catalogservice.domain.catalog.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftd.catalogservice.domain.catalog.Catalog;
import com.ftd.catalogservice.domain.catalog.repository.CatalogRepository;
import com.ftd.catalogservice.domain.catalog.service.CatalogService;
import com.ftd.catalogservice.handling.NoRecordsFoundException;

/**
 * @author Abhishek Mallick
 *
 */
@Service
public class CatalogServiceImpl implements CatalogService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CatalogRepository catalogRepository;

	@Override
	public List<Catalog> getAllCatalogs() throws NoRecordsFoundException {

		logger.debug("[CatalogServiceImpl.getAllCatalogs()]");
		List<Catalog> queriedCatalogs = (List<Catalog>) catalogRepository.findAll();

		if (queriedCatalogs.isEmpty())
			throw new NoRecordsFoundException("No Catalogs Found in Repository ");

		return queriedCatalogs;
	}

	@Override
	public Catalog getCatalog(String catalogId) throws NoRecordsFoundException {

		logger.debug("[CatalogServiceImpl.getCatalog()] , Catalog Id Passed is ::" + catalogId);
		Catalog queriedCatalog = catalogRepository.findCatalogById(catalogId);

		if (null == queriedCatalog)
			throw new NoRecordsFoundException("No Catalog Found in Repository with Id : " + catalogId);

		return queriedCatalog;
	}

}
