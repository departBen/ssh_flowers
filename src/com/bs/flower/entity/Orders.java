package com.bs.flower.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer ordersId;
	private Users users;
	private Integer num;
	private Double sum;
	private Timestamp createTime;
	private Set ordersDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** minimal constructor */
	public Orders(Users users, Integer num, Double sum, Timestamp createTime) {
		this.users = users;
		this.num = num;
		this.sum = sum;
		this.createTime = createTime;
	}

	/** full constructor */
	public Orders(Users users, Integer num, Double sum, Timestamp createTime, Set ordersDetailses) {
		this.users = users;
		this.num = num;
		this.sum = sum;
		this.createTime = createTime;
		this.ordersDetailses = ordersDetailses;
	}

	// Property accessors

	public Integer getOrdersId() {
		return this.ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getSum() {
		return this.sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Set getOrdersDetailses() {
		return this.ordersDetailses;
	}

	public void setOrdersDetailses(Set ordersDetailses) {
		this.ordersDetailses = ordersDetailses;
	}

}