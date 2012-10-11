package com.ego.po;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class RechargeRecord {
	private Integer recId;
	private String memUserName;
	private Timestamp rechargeTime;
	private BigDecimal rechargeAmount;

	public Integer getRecId() {
		return recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getMemUserName() {
		return memUserName;
	}

	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}

	public Timestamp getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(Timestamp rechargeTime) {
		this.rechargeTime = rechargeTime;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

}
