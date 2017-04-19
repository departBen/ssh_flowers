package com.bs.flower.action;

import com.bs.flower.entity.Category;
import com.bs.flower.entity.Goods;
import com.bs.flower.service.CategoryService;
import com.bs.flower.service.FlowerService;
import com.bs.flower.utils.Pager;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public class FlowerAction extends ActionSupport {
    /**
     * spring管理
     */
    private CategoryService categoryService;
    private FlowerService flowerService;

    /**
     * struts管理
     */
    private List<Category> categories;
    private List<Goods> newFlowers;
    private List<Goods> flowers;
    private Category category;
    private int currentPage =1;
    private Pager page;


    /**
     * 获取鲜花分类列表
     * @return
     */
    public String browseCategory(){
        categories = categoryService.getAllCategories();
        return "success";
    }

    /**
     * 获取新添加鲜花
     * @return
     */
    public String bowerseNewFlower(){
        newFlowers =flowerService.getNewFlowers();
        return "newFlower";
    }
    
    /**
     * 鲜花分页显示
     * @return
     */
    public String browseFlowerByPage(){
        int totalSize = flowerService.getTotalByCategoryId(category.getId());
        page = new Pager(currentPage,totalSize);
        flowers = flowerService.getFlowerByCategoryidPaging(category.getId(),currentPage,page.getPageSize());
        return "pageFlower";
    }
    

//-------------------------get set----------------------------
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public FlowerService getFlowerService() {
        return flowerService;
    }

    public List<Goods> getNewFlowers() {
        return newFlowers;
    }

    public void setNewFlowers(List<Goods> newFlowers) {
        this.newFlowers = newFlowers;
    }

    public void setFlowerService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Goods> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Goods> flowers) {
        this.flowers = flowers;
    }

    public Pager getPage() {
        return page;
    }

    public void setPage(Pager page) {
        this.page = page;
    }
}
