package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.SecondCategoryDao;
import com.ego.po.SecondCategory;
import com.ego.vo.SecondCategoryVO;

public class SecondCategoryService {
	SecondCategoryDao dao = new SecondCategoryDao();

	public ArrayList<SecondCategoryVO> getAll() {
		return dao.getAll();
	}

	public boolean addSecCategory(SecondCategory sc) {
		return dao.addSecCategory(sc);
	}

	public boolean delSecCategory(int secCategoryId) {
		return dao.delSecCategory(secCategoryId);
	}
	
	public SecondCategory getById(int secCategoryId){
		return dao.getById(secCategoryId);
	}
	
	public boolean modSecCategory(SecondCategory sc) {
		return dao.modSecCategory(sc);
	}
	
	public ArrayList<Integer> getSecCtyIdByCtyId(int ctyId) {
		return dao.getSecCtyIdByCtyId(ctyId);
	}

}
