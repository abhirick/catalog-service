/**
 * 
 */

package com.ftd.catalogservice.domain.category;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abhishek Mallick
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String title;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "long_description")
	private String longDescription;

	private String brand;

	private boolean status;

	private boolean discountable;

	private String fulfiller;

	@Column(name = "creation_date")
	private Date creationDate;

	private String type;

	@ElementCollection
	private List<String> ancestorCategories;

	@ElementCollection
	private List<String> childCategories;

	@ElementCollection
	private List<String> childSkus;

	@ElementCollection
	private List<String> childProducts;

	@ElementCollection
	private List<String> catalogIds;

	public Category(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		} catch (Exception exp) {
			return "";
		}
	}

}
