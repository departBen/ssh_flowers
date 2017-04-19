package com.bs.flower.service;

import java.util.List;

import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Users;

/**
 * Created by ben on 2017/4/5.
 */
public interface UserService {
    /**
     * 用户注册
     * @param users
     */
    void save(Users users);
    void saveAdmin(Admin admin);
    /**
     * 验证用户名是否存在
     */
    Users findByUserName(String username);
    /**
     * 根据id找到用户
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
   /**
    * 管理员登陆
    * @param admin
    * @return
    */
   Admin checkAdmin(Admin admin);
}
