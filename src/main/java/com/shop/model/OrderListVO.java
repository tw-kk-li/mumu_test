package com.shop.model;

import java.io.Serializable;

public class OrderListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer prodOptId;
	private Integer prodOptQuantity;
	private Integer orderExtendedListPrice;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProdOptId() {
		return prodOptId;
	}

	public void setProdOptId(Integer prodOptId) {
		this.prodOptId = prodOptId;
	}

	public Integer getProdOptQuantity() {
		return prodOptQuantity;
	}

	public void setProdOptQuantity(Integer prodOptQuantity) {
		this.prodOptQuantity = prodOptQuantity;
	}

	public Integer getOrderExtendedListPrice() {
		return orderExtendedListPrice;
	}

	public void setOrderExtendedListPrice(Integer orderExtendedListPrice) {
		this.orderExtendedListPrice = orderExtendedListPrice;
	}

}
