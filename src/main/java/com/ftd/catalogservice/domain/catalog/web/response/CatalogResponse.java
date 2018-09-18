
package com.ftd.catalogservice.domain.catalog.web.response;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * @author Abhishek Mallick
 *
 */
@Data
@Builder
public class CatalogResponse {

	private String id;

	private String displayName;

	private String shortDescription;

	private String longDescription;

	private boolean status;

	private String catalogCreationDate;

	private String type;

	private List<String> siteIds;

	private boolean isRoot;

	private List<String> shippingMethods;

	private String defaultShippingMethod;

	private List<String> ancestorCatalogs;

	private List<String> childCatalogs;

	private List<String> rootCategories;

	private List<String> categories;

}
