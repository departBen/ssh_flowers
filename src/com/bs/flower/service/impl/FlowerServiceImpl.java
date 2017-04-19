package com.bs.flower.service.impl;

import com.bs.flower.dao.FlowerDao;
import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Orders;
import com.bs.flower.service.FlowerService;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public class FlowerServiceImpl implements FlowerService {

    private FlowerDao flowerDao;

    @Override
    public List<Goods> getNewFlowers() {
        return flowerDao.getNewFlowers();
    }

    @Override
    public List<Goods> getFlowerByCategoryidPaging(int categoryId, int currentPage, int pageSize) {
        return flowerDao.getFlowerByCategoryidPaging(categoryId,currentPage,pageSize);
    }

    @Override
    public int getTotalByCategoryId(int categoryId) {
        return flowerDao.getTotalByCategoryId(categoryId);
    }

    @Override
    public Goods getFlowerById(int id) {
        return flowerDao.getFlowerById(id);
    }

    @Override
    public Orders saveOrder(Orders orders) {
        return flowerDao.saveOrder(orders);
    }
    
    @Override
	public List<Goods> getFlowerpagging(int currentPage, int pageSize) {
		return flowerDao.getFlowerpagging(currentPage, pageSize);
	}

	@Override
	public int getTotal() {
		return flowerDao.getTotal();
	}

    public FlowerDao getFlowerDao() {
        return flowerDao;
    }

    public void setFlowerDao(FlowerDao flowerDao) {
        this.flowerDao = flowerDao;
    }

	@Override
	public Goods saveOrUpdate(Goods flower) {
		return flowerDao.saveOrUpdate(flower);
	}

	@Override
	public void deleteFlower(int id) {
		flowerDao.deleteFlower(id);
	}

	@Override
	public List<Orders> getOrdersPagging(int currentPage, int pageSize) {
		
		return flowerDao.getOrdersPagging(currentPage, pageSize);
	}

	@Override
	public int getOrderTotal() {
		return flowerDao.getOrderTotal();
	}

	
}
