package com.ego.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ego.dao.MemberDao;
import com.ego.po.Member;

public class MemberService {
	
	MemberDao dao = new MemberDao();
	private int pageSize = 10; // 设置页面显示尺寸
	
	public ArrayList<Member> getAll() {
		return dao.getAll();
	}
	
	public Member getByUserName(String username) {
		return dao.getByUserName(username);
	}
	
	public void insert(Member member) {
		dao.insert(member);
	}
	
	public void delete(String memUserName) {
		dao.delete(memUserName);
	}
	
	public boolean compareUsername(String username){
		return dao.compareUsername(username);
	}
	
	public ArrayList<Member> getByPage(int page) {
		return dao.getByPage(page, pageSize);
	}

	public int getTotalPage() {
		return dao.getTotalPage(pageSize);
	}
	
	public void disableMember(String memUserName) {
		dao.disableMember(memUserName);
	}
	
	public void enableMember(String memUserName) {
		dao.enableMember(memUserName);
	}
	
	public void modifyMember(Member mem) {
		dao.modifyMember(mem);
	}
	
	public BigDecimal getBalanceByName(String memUserName) {
		return dao.getBalanceByName(memUserName);
	}
	
	public boolean reduceBalance(BigDecimal total, String memUserName) {
		return dao.reduceBalance(total, memUserName);
	}
	
	public boolean addConsumeTotal(BigDecimal total, String memUserName) {
		return dao.addConsumeTotal(total, memUserName);
	}

}
