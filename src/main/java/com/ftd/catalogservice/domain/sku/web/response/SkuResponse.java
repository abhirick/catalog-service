/**
 * 
 */
package com.ftd.catalogservice.domain.sku.web.response;

import java.util.List;

/**
 * @author Abhishek Mallick
 *
 */
import lombok.Builder;
import lombok.Data;

/**
 * @author Abhishek Mallick
 *
 */
@Data
@Builder
public class SkuResponse {

	private String id;

	private String defaultShippingMethod;

	private boolean onSale;

	private boolean isActive;

	private String title;

	private String displayName;

	private String shortDescription;

	private String longDescription;

	private String brand;

	private boolean status;

	private boolean discountable;

	private String fulfiller;

	private boolean hasPrice;

	private boolean isAvailable;

	private String skuCreationDate;

	private boolean nonReturnable;

	private boolean onlineOnly;

	private String type;

	private String vatCode;

	private List<String> parentProducts;

	private List<String> catalogIds;

}
