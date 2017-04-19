package com.bs.flower.dao;

import java.util.List;

import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Users;

/**
 * Created by ben on 2017/4/5.
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     */
    void add(Users user);
    void addAdmin(Admin admin);
    /**
     * 根据用户名查找用户
     */
    Users findByUserName(String username);
    
    /**
     * 根据用户id找到用户
     * @param id
     * @return
     */
    Users getUserById(int id);

    /**
     * 验证用户
     * @param users
     * @return
     */
    Users checkUser(Users users);
    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    Admin checkAdmin(Admin admin);
    
    /**
     * 分页查询所有用户
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Users> getUsersPagging(int currentPage, int pageSize);
    /**
     * 用户总数
     * @return
     */
    int getOrderTotal();
}
