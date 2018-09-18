/**
 * 
 */
package com.ftd.catalogservice.domain.sku;

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
public class Sku implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "default_shipping_method")
	private String defaultShippingMethod;

	@Column(name = "on_sale")
	private boolean onSale;

	@Column(name = "is_active")
	private boolean isActive;

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

	@Column(name = "parent_product")
	private String parentProduct;

	@ElementCollection
	private List<String> catalogIds;

	public Sku(String id) {
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
