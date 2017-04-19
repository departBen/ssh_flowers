package com.bs.flower.service;

import com.bs.flower.entity.Category;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public interface CategoryService {
    /**
     * 获取所有鲜花分类
     * @return
     */
    List<Category> getAllCategories();
    
    /**
     * 新增鲜花分类
     * @param category
     */
    void saveCategory(Category category);
}
