/**
 * 
 */
package com.ftd.catalogservice.domain.product.web.response;

import java.util.List;

import com.ftd.catalogservice.domain.sku.web.response.SkuResponse;

import lombok.Builder;
import lombok.Data;

/**
 * @author Abhishek Mallick
 *
 */
@Data
@Builder
public class ProductResponse {

	private String id;

	private String title;

	private String displayName;

	private String shortDescription;

	private String longDescription;

	private String brand;

	private boolean status;

	private boolean discountable;

	private String fulfiller;

	private boolean hasAvailableChildSkus;

	private boolean hasPrice;

	private boolean isAvailable;

	private String productCreationDate;

	private boolean nonReturnable;

	private boolean onlineOnly;

	private String type;

	private String vatCode;

	private List<String> alternativeProducts;

	private List<String> ancestorCategories;

	private List<SkuResponse> skuList;

	private List<String> catalogIds;

}
