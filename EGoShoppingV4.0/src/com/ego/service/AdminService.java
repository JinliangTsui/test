package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.AdminDao;
import com.ego.po.Admin;

public class AdminService {
	AdminDao dao = new AdminDao();
	
	public String getAuthority(String adUserName) {
		return dao.getAuthority(adUserName);
	}
	
	public ArrayList<Admin> getByAuthority() {
		return dao.getByAuthority();
	}
	
	public void insert(Admin admin) {
		dao.insert(admin);
	}
	
	public boolean checkName(String adUserName) {
		return dao.checkName(adUserName);
	}
	
	public boolean delete(String adUserName) {
		return dao.delete(adUserName);
	}
	
	public Admin getByName(String adUserName) {
		return dao.getByName(adUserName);
	}
	
	public boolean modify(Admin admin) {
		return dao.modify(admin);
	}

}
