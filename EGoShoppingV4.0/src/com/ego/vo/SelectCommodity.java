package com.ego.vo;

import com.ego.po.Commodity;

public class SelectCommodity {

	private Commodity commodity;
	private int number = 1;

	public SelectCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public int getNumber() {
		return number;
	}

	public void addNumber() {
		this.number++;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commodity == null) ? 0 : commodity.hashCode());
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
		SelectCommodity other = (SelectCommodity) obj;
		if (commodity == null) {
			if (other.commodity != null)
				return false;
		} else if (!commodity.equals(other.commodity))
			return false;
		return true;
	}

}
