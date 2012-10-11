package com.ego.po;

public class Order {

	private Integer orderId;
	private String memUserName;
	private Integer adrId;
	private String orderState;
	private String orderNote;
	private String orderPayed;

	public String getOrderPayed() {
		return orderPayed;
	}

	public void setOrderPayed(String orderPayed) {
		this.orderPayed = orderPayed;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getMemUserName() {
		return memUserName;
	}

	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}

	public Integer getAdrId() {
		return adrId;
	}

	public void setAdrId(Integer adrId) {
		this.adrId = adrId;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

}
