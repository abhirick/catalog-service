/**
 * 
 */
package com.ftd.catalogservice.domain.category.web.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abhishek Mallick
 *
 */
@Data
@Builder
public class CategoryResponse {

	private String id;

	private String title;

	private String displayName;

	private String shortDescription;

	private String longDescription;

	private String brand;

	private boolean status;

	private boolean discountable;

	private String fulfiller;

	private String categoryCreationDate;

	private String type;

	private List<String> ancestorCategories;

	private List<String> childCategories;

	private List<String> childSkus;

	private List<String> childProducts;

	private List<String> catalogIds;

}
