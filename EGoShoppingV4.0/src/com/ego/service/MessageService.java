package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.MessageDao;
import com.ego.po.Message;

public class MessageService {
	
	MessageDao dao = new MessageDao();
	
	public boolean insert(Message msg) {
		return dao.insert(msg);
	}
	
	public ArrayList<Message> getAll(String memUserName) {
		return dao.getAll(memUserName);
	}
	
	public ArrayList<Message> getAll() {
		return dao.getAll();
	}
	
	public Message getById(int msgId) {
		return dao.getById(msgId);
	}
	
	public boolean reMessage(Message msg) {
		return dao.reMessage(msg);
	}
	
	public boolean delete(int msgId) {
		return dao.delete(msgId);
	}

}
