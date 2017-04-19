package com.bs.flower.dao.impl;

import com.bs.flower.dao.CategoryDao;
import com.bs.flower.entity.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ben on 2017/4/8.
 */
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public List<Category> getAllCategories() {
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        List<Category> categories = query.list();
        return categories;
    }
    
    @Override
	public void saveCategory(Category category) {
		session = sessionFactory.getCurrentSession();
		session.save(category);
	}
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	
}
