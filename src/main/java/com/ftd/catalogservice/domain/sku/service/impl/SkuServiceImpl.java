/**
 * 
 */
package com.ftd.catalogservice.domain.sku.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftd.catalogservice.domain.sku.Sku;
import com.ftd.catalogservice.domain.sku.repository.SkuRepository;
import com.ftd.catalogservice.domain.sku.service.SkuService;
import com.ftd.catalogservice.handling.NoRecordsFoundException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author Abhishek Mallick
 *
 */
@Service
public class SkuServiceImpl implements SkuService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SkuRepository skuRepository;

	@Override
	public List<Sku> getAllSkus() throws NoRecordsFoundException {

		List<Sku> queriedSkus;

		try {

			logger.debug("[SkuServiceImpl.getAllSkus()]");
			queriedSkus = (List<Sku>) skuRepository.findAll();

			if (queriedSkus.isEmpty())
				throw new NoRecordsFoundException("No Skus Found in Repository ");

		} finally {

		}
		return queriedSkus;
	}

	/**
	 * ignoreExceptions - Ignore NoRecordsFoundException so that it does not execute
	 * fall back mechanism in this case.
	 */
	@HystrixCommand(fallbackMethod = "getCachedSkuById", ignoreExceptions = { NoRecordsFoundException.class })
	@Override
	public Sku getSku(String skuId) throws NoRecordsFoundException {

		logger.debug("[SkuServiceImpl.getSku()] , Sku Id Passed is ::" + skuId);
		return Optional.ofNullable(skuRepository.findSkuById(skuId))
				.orElseThrow(() -> new NoRecordsFoundException("No Sku Found in Repository with Id : " + skuId));
	}

	/**
	 * Fallback method should have the same signature of a wrapped method and must
	 * reside in the same class. Now when the getSku fails or gets delayed more than
	 * a given threshold, Hystrix fallbacks to getCachedSkuById.
	 * 
	 * @param skuId
	 * @return
	 * @throws NoRecordsFoundException
	 */
	private Sku getCachedSkuById(String skuId) throws NoRecordsFoundException {
		Sku newSku = new Sku();
		newSku.setId(skuId);
		return newSku;
	}

	@HystrixCommand(fallbackMethod = "getCachedSkuFromParentProduct", commandKey = "getSkuFromParentProduct", groupKey = "Sku-Details", ignoreExceptions = {
			NoRecordsFoundException.class })
	@Override
	public List<Sku> getSkuFromParentProduct(String productId) throws NoRecordsFoundException {

		logger.debug("[SkuServiceImpl.getSkuFromParentProduct()] , Product Id Passed is ::" + productId);
		List<Sku> queriedSkus = skuRepository.findSkuByParentProduct(productId);

		if (queriedSkus.isEmpty())
			throw new NoRecordsFoundException("No Skus Found in Repository for Parent Product Id " + productId);

		return queriedSkus;
	}

	private List<Sku> getCachedSkuFromParentProduct(String productId) throws NoRecordsFoundException {
		List<Sku> dummySkuList = new ArrayList<>();
		Sku newSku = new Sku();
		newSku.setId("123");
		dummySkuList.add(newSku);
		return dummySkuList;

	}
}
