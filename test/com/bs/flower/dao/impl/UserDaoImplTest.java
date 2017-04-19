package com.bs.flower.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bs.flower.dao.UserDao;
import com.bs.flower.entity.Admin;
import com.bs.flower.entity.Orders;
import com.bs.flower.entity.OrdersDetails;
import com.bs.flower.entity.Users;
import com.bs.flower.service.FlowerService;
import com.bs.flower.service.UserService;

public class UserDaoImplTest {
	/**
	 * 添加管理员
	 */
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = context.getBean("userService",UserService.class);
		Admin admin = new Admin();
		admin.setUsername("root");
		admin.setPassword("root");
		
		userService.saveAdmin(admin);
	}
	

}
