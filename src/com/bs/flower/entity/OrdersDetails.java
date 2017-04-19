package com.bs.flower.entity;

/**
 * OrdersDetails entity. @author MyEclipse Persistence Tools
 */

public class OrdersDetails implements java.io.Serializable {

	// Fields

	private Integer id;
	private Orders orders;
	private String goodsName;
	private Double price;
	private Integer num;

	// Constructors

	/** default constructor */
	public OrdersDetails() {
	}

	/** full constructor */
	public OrdersDetails(Orders orders, String goodsName, Double price, Integer num) {
		this.orders = orders;
		this.goodsName = goodsName;
		this.price = price;
		this.num = num;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}