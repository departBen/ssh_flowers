package com.bs.flower.service;

import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Orders;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public interface FlowerService {
    /**
     * 查询新入库鲜花
     * @return
     */
    List<Goods> getNewFlowers();

    /**
     * 根据分类分页查询
     * @param categoryId
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Goods> getFlowerByCategoryidPaging(int categoryId,int currentPage,int pageSize);

    /**
     * 根据分类查询花品数量
     * @param categoryId
     * @return
     */
    int getTotalByCategoryId(int categoryId);

    /**
     * 根据id查询花品
     * @param id
     * @return
     */
    Goods getFlowerById(int id);

    /**
     * 保存订单
     * @param orders
     */
    Orders saveOrder(Orders orders);
    
    /**
     * 保存新鲜花
     * @param flower
     * @return
     */
    Goods saveOrUpdate(Goods flower);
    
    /**
     * 分页查询鲜花
     * @return
     */
    List<Goods> getFlowerpagging(int currentPage, int pageSize);
    /**
     * 鲜花总数
     * @return
     */
    int getTotal();
    
    /**
     * 删除花品
     * @param id
     */
    void deleteFlower(int id);
    
    /**
     * 分页查询订单
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Orders> getOrdersPagging(int currentPage, int pageSize);
    /**
     * 订单总数
     * @return
     */
    int getOrderTotal();
}
