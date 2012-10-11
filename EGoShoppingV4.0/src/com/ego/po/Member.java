package com.ego.po;

import java.math.BigDecimal;

public class Member {
	
	private String memUserName;
	private String memPassword;
	private String memName;
	private String idNumber;
	private String tel;
	private String email;
	private BigDecimal consumeTotal;
	private BigDecimal balance;
	private String state;
	
	public String getMemUserName() {
		return memUserName;
	}
	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getConsumeTotal() {
		return consumeTotal;
	}
	public void setConsumeTotal(BigDecimal consumeTotal) {
		this.consumeTotal = consumeTotal;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
