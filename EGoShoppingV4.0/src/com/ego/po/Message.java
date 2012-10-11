package com.ego.po;

import java.util.Date;


public class Message {

	private Integer msgId;
	private String memUserName;
	private String adUserName;
	private String msgTime;
	private String msgContent;
	private String reContent;
	private String reTime;


	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getReTime() {
		return reTime;
	}

	public void setReTime(String reTime) {
		this.reTime = reTime;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getMemUserName() {
		return memUserName;
	}

	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}

	public String getAdUserName() {
		return adUserName;
	}

	public void setAdUserName(String adUserName) {
		this.adUserName = adUserName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}


}
