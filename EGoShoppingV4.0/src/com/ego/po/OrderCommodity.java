package com.ego.po;

import java.math.BigDecimal;

public class OrderCommodity {

	private Integer itemNo;
	private Integer orderId;
	private String commodityName;
	private BigDecimal commodityPrice;
	private Integer commodityAmount;
	private Integer commodityId;

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public BigDecimal getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(BigDecimal commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Integer getCommodityAmount() {
		return commodityAmount;
	}

	public void setCommodityAmount(Integer commodityAmount) {
		this.commodityAmount = commodityAmount;
	}

}
