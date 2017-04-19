package com.bs.flower.service.impl;

import java.util.List;

import com.bs.flower.dao.UserDao;
import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Users;
import com.bs.flower.service.UserService;

/**
 * Created by ben on 2017/4/5.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    @Override
    public void save(Users users) {
        userDao.add(users);
    }

    @Override
    public void saveAdmin(Admin admin) {
        userDao.addAdmin(admin);
    }

    @Override
    public Users findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public Users checkUser(Users users) {
        return userDao.checkUser(users);
    }
    
    @Override
	public List<Users> getUsersPagging(int currentPage, int pageSize) {
		return userDao.getUsersPagging(currentPage, pageSize);
	}

	@Override
	public int getOrderTotal() {
		return userDao.getOrderTotal();
	}

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public Users getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public Admin checkAdmin(Admin admin) {
		return userDao.checkAdmin(admin);
	}

}
