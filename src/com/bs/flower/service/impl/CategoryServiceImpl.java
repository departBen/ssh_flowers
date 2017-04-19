package com.bs.flower.service.impl;

import com.bs.flower.dao.CategoryDao;
import com.bs.flower.entity.Category;
import com.bs.flower.service.CategoryService;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
    
    @Override
	public void saveCategory(Category category) {
		categoryDao.saveCategory(category);
	}
    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
