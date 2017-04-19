package com.bs.flower.dao.impl;

import com.bs.flower.dao.UserDao;
import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ben on 2017/4/5.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void add(Users user) {
        session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    @Override
    public void addAdmin(Admin admin) {
        session = sessionFactory.getCurrentSession();
        session.save(admin);
    }

    @Override
    public Users findByUserName(String username) {
        String hql = "select u from Users u where u.userName = ?";
        session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setParameter(0,username);
        List<Users> usersList = query.list();
        if(usersList != null && usersList.size()>0){
            return usersList.get(0);
        }
        return null;
    }
    
    @Override
	public Admin checkAdmin(Admin admin) {
		session = sessionFactory.getCurrentSession();
		String hql = "select a from Admin a where a.username = ? and a.password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, admin.getUsername());
		query.setParameter(1, admin.getPassword());
		List<Admin> adminList = query.list();
		if(adminList != null && adminList.size() > 0){
			return adminList.get(0);
		}
		return null;
	}

    @Override
    public Users checkUser(Users users) {
        session = sessionFactory.getCurrentSession();
        String hql = "select u from  Users  u where u.userName = ? and u.password = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,users.getUserName());
        query.setParameter(1,users.getPassword());
        List<Users> usersList = query.list();
        if(usersList != null && usersList.size()>0){
            return usersList.get(0);
        }
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Users> getUsersPagging(int currentPage, int pageSize) {
		session = sessionFactory.getCurrentSession();
    	String hql = "from Users";
    	Query query = session.createQuery(hql);
    	int startRow = (currentPage - 1)*pageSize;
        query.setFirstResult(startRow);
        query.setMaxResults(pageSize);
        List<Users> users = query.list();
        return users;
	}

	@Override
	public int getOrderTotal() {
		session = sessionFactory.getCurrentSession();
        String hql = "from Users";
        Query query = session.createQuery(hql);
        List<Users> users = query.list();
        return users.size();
	}

	@Override
	public Users getUserById(int id) {
		session = sessionFactory.getCurrentSession();
		return (Users) session.get(Users.class, id);
	}

	
}
