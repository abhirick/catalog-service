/**
 * 
 */
package com.ftd.catalogservice.domain.category.web.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author Abhishek Mallick
 *
 */

@Data
@Builder
public class FTDCategoryResponse {

	private String name;

	private String description;

	private String imageUrl;

	private String relativePath;

}