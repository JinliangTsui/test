package com.ego.service;

import java.math.BigDecimal;

import com.ego.dao.MemberDao;
import com.ego.dao.RechargeRecordDao;
import com.ego.po.RechargeRecord;

public class RechargeRecordService {
	RechargeRecordDao dao = new RechargeRecordDao();
	MemberDao memDao = new MemberDao();
	
	public boolean insert(RechargeRecord rr) {
		return dao.insert(rr);
	}
	
	public boolean recharge(String memUserName, BigDecimal rechargeAmount) {
		return memDao.recharge(memUserName, rechargeAmount);
	}

}
