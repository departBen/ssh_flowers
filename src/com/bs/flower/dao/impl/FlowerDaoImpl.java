package com.bs.flower.dao.impl;

import com.bs.flower.dao.FlowerDao;
import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Orders;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public class FlowerDaoImpl implements FlowerDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Goods> getNewFlowers() {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Goods g order by g.id desc");
        query.setFirstResult(0);
        query.setMaxResults(4);
        List<Goods> goods = query.list();
        return goods;
    }

    @Override
    public List<Goods> getFlowerByCategoryidPaging(int categoryId, int currentPage, int pageSize) {
        session = sessionFactory.getCurrentSession();
        String hql = "from Goods g where g.category.id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,categoryId);
        int startRow = (currentPage - 1)*pageSize;
        query.setFirstResult(startRow);
        query.setMaxResults(pageSize);
        List<Goods> flowers = query.list();
        return flowers;
    }

    @Override
    public int getTotalByCategoryId(int categoryId) {
        session = sessionFactory.getCurrentSession();
        String hql = "from Goods g where g.category.id = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,categoryId);
        List<Goods> flowers = query.list();
        return flowers.size();
    }
    
    @Override
	public List<Goods> getFlowerpagging(int currentPage, int pageSize) {
    	session = sessionFactory.getCurrentSession();
    	String hql = "from Goods";
    	Query query = session.createQuery(hql);
    	int startRow = (currentPage - 1)*pageSize;
        query.setFirstResult(startRow);
        query.setMaxResults(pageSize);
        List<Goods> flowers = query.list();
        return flowers;
	}

	@Override
	public int getTotal() {
		session = sessionFactory.getCurrentSession();
        String hql = "from Goods";
        Query query = session.createQuery(hql);
        List<Goods> flowers = query.list();
        return flowers.size();
	}

    @Override
    public Goods getFlowerById(int id) {
        session = sessionFactory.getCurrentSession();
        Goods flower = (Goods) session.get(Goods.class,id);
        return flower;
    }

    @Override
    public Orders saveOrder(Orders orders) {
        session = sessionFactory.getCurrentSession();
        session.save(orders);
        return orders;
    }
    
    @Override
	public Goods saveOrUpdate(Goods flower) {
		session = sessionFactory.getCurrentSession();
		return (Goods) session.merge(flower);
	}
    
    @Override
	public void deleteFlower(int id) {
    	session = sessionFactory.getCurrentSession();
    	Goods flower = (Goods) session.get(Goods.class, id);
    	session.delete(flower);
	}
    
    @Override
	public List<Orders> getOrdersPagging(int currentPage, int pageSize) {
    	session = sessionFactory.getCurrentSession();
    	String hql = "from Orders";
    	Query query = session.createQuery(hql);
    	int startRow = (currentPage - 1)*pageSize;
        query.setFirstResult(startRow);
        query.setMaxResults(pageSize);
        List<Orders> orders = query.list();
        for (Orders orders2 : orders) {
        	if(orders2.getUsers() != null){
        		orders2.getUsers().getRealName();
        	}
		}
        return orders;
	}

	@Override
	public int getOrderTotal() {
		session = sessionFactory.getCurrentSession();
        String hql = "from Orders";
        Query query = session.createQuery(hql);
        List<Orders> orders = query.list();
        return orders.size();
	}
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
