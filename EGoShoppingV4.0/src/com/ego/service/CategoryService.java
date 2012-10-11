package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.CategoryDao;
import com.ego.po.Category;

public class CategoryService {
	CategoryDao dao = new CategoryDao();

	public ArrayList<Category> getAll() {
		return dao.getAll();
	}

}
