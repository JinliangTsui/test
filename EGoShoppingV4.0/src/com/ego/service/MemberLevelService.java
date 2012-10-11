package com.ego.service;

import java.math.BigDecimal;

import com.ego.dao.MemberDao;
import com.ego.dao.MemberLevelDao;

public class MemberLevelService {
	MemberLevelDao dao = new MemberLevelDao();
	MemberDao memDao = new MemberDao();
	
	public float getDiscountByName(String memUserName) {
		BigDecimal money = memDao.getConsumeTotalByName(memUserName);
		return dao.getDiscountByName(money);
	}

}
