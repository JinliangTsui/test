package com.ego.po;

import java.math.BigDecimal;

public class MemberLevel {
	
	private Integer levelId;
	private float discount;
	private BigDecimal standard;
	private String levelDesc;

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public BigDecimal getStandard() {
		return standard;
	}

	public void setStandard(BigDecimal standard) {
		this.standard = standard;
	}

	public String getLevelDesc() {
		return levelDesc;
	}

	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

}
