package com.ego.po;

import java.math.BigDecimal;

public class Commodity {
	private Integer commId;
	private Integer secCategoryId;
	private String commName;
	private BigDecimal price;
	private String commImg;
	private String commDesc;
	private Integer commAmount;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commId == null) ? 0 : commId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (commId == null) {
			if (other.commId != null)
				return false;
		} else if (!commId.equals(other.commId))
			return false;
		return true;
	}

	private Integer saledAmount;

	public Integer getSaledAmount() {
		return saledAmount;
	}

	public void setSaledAmount(Integer saledAmount) {
		this.saledAmount = saledAmount;
	}

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public Integer getSecCategoryId() {
		return secCategoryId;
	}

	public void setSecCategoryId(Integer secCategoryId) {
		this.secCategoryId = secCategoryId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCommImg() {
		return commImg;
	}

	public void setCommImg(String commImg) {
		this.commImg = commImg;
	}

	public String getCommDesc() {
		return commDesc;
	}

	public void setCommDesc(String commDesc) {
		this.commDesc = commDesc;
	}

	public Integer getCommAmount() {
		return commAmount;
	}

	public void setCommAmount(Integer commAmount) {
		this.commAmount = commAmount;
	}

}
