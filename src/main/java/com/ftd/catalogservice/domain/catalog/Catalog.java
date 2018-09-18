/**
 * 
 */

package com.ftd.catalogservice.domain.catalog;

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
public class Catalog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "display_name")
	private String displayName;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "long_description")
	private String longDescription;

	private boolean status;

	@Column(name = "creation_date")
	private Date creationDate;

	private String type;

	@ElementCollection
	private List<String> siteIds;

	@Column(name = "is_root")
	private boolean isRoot;

	@ElementCollection
	private List<String> shippingMethods;

	@Column(name = "default_shipping_method")
	private String defaultShippingMethod;

	@ElementCollection
	private List<String> ancestorCatalogs;

	@ElementCollection
	private List<String> childCatalogs;

	@ElementCollection
	private List<String> rootCategories;

	@ElementCollection
	private List<String> categories;

	public Catalog(String id) {
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
