package com.ftd.catalogservice.domain.shared;


public class SearchListResponse {
	
	private String productLink;
	private String productImage;
	private String productTitle ;
	private String productPrice ;
	

	public String getProductLink() {
		return productLink;
	}
	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	

}
