package com.ego.service;

import com.ego.dao.LoginDao;
import com.ego.po.Admin;
import com.ego.po.Member;

public class LoginService {

	LoginDao dao = new LoginDao();

	public boolean loginCheck(Member mem) {
		return dao.loginCheck(mem);
	}

	public boolean admin_LoginCheck(Admin admin) {
		return dao.admin_LoginCheck(admin);
	}
	
	public int getState(Member mem) {
		return dao.getState(mem);
	}

}
