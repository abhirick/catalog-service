/**
 * 
 */
package com.ftd.catalogservice.domain.product;

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
 * <p>
 * Inventory Document
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {

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

	@Column(name = "has_available_child_skus")
	private boolean hasAvailableChildSkus;

	@Column(name = "has_price")
	private boolean hasPrice;

	@Column(name = "is_available")
	private boolean isAvailable;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "non_returnable")
	private boolean nonReturnable;

	@Column(name = "online_only")
	private boolean onlineOnly;

	private String type;

	@Column(name = "vat_code")
	private String vatCode;

	@ElementCollection
	private List<String> alternativeProducts;

	@ElementCollection
	private List<String> ancestorCategories;

	@ElementCollection
	private List<String> childSKUs;

	@ElementCollection
	private List<String> catalogIds;

	@ElementCollection
	private List<String> thumbnailImages;

	@ElementCollection
	private List<String> smallImages;

	@ElementCollection
	private List<String> largeImages;

	@ElementCollection
	private List<String> videos;

	public Product(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			return "";
		}
	}

}
