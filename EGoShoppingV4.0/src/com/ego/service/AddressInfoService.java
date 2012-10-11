package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.AddressInfoDao;
import com.ego.po.AddressInfo;

public class AddressInfoService {
	
	AddressInfoDao dao = new AddressInfoDao();
	
	public ArrayList<AddressInfo> getAll(String memUserName) {
		return dao.getAll(memUserName);
	}
	
	public AddressInfo getById(String memUserName, int adrId) {
		return dao.getById(memUserName, adrId);
	}
	
	public boolean insert(AddressInfo adrInfo) {
		return dao.insert(adrInfo);
	}
	
	public boolean modify(AddressInfo adrInfo) {
		return dao.modify(adrInfo);
	}
	
	public boolean delete(int adrId, String memUserName) {
		return dao.delete(adrId, memUserName);
	}

}
