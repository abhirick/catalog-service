/**
 * 
 */
package com.ftd.catalogservice.domain.category.web.request;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Abhishek Mallick
 *
 */
@Data
@Builder
public class ParseHTMLRequest {

	@NotBlank(message = "URL is mandatory.")
	private String urlToParse;

}
