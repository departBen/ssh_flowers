package com.bs.flower.action;

import com.bs.flower.entity.Goods;
import com.bs.flower.entity.Orders;
import com.bs.flower.entity.OrdersDetails;
import com.bs.flower.entity.Users;
import com.bs.flower.service.FlowerService;
import com.bs.flower.utils.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ben on 2017/4/9.
 */
public class ShoppingAction extends ActionSupport {


    //spring管理
    private FlowerService flowerService;

    //struts管理
    private int num;
    private int id;
    private Goods flower;
    private Orders order;

    /**
     * 添加花品到购物车
     * @return
     */
    public String addToCart(){

        Goods flowerGoods = flowerService.getFlowerById(flower.getId());
        OrdersDetails ordersDetails = new OrdersDetails();
        ordersDetails.setNum(num);
        ordersDetails.setGoodsName(flowerGoods.getGoodsName());
        ordersDetails.setPrice(flowerGoods.getPrice());

        //购物车放在session
        Map session = ActionContext.getContext().getSession();
        ShoppingCart cart = (ShoppingCart) session.get("cart");
        if (cart == null){
            cart = new ShoppingCart();
        }
        cart.addFlower(flower.getId(),ordersDetails);
        session.put("cart",cart);
        return SUCCESS;
    }

    /**
     * 更新购物车数据
     * @return
     */
    public String updateCart(){
        Map session = ActionContext.getContext().getSession();
        ShoppingCart cart = (ShoppingCart) session.get("cart");
        cart.updateCart(id,num);
        session.put("cart",cart);
        return "updateCartSuccess";
    }

    /**
     * 提交订单
     * @return
     */
    public String commitOrder(){
    	
    	Map session = ActionContext.getContext().getSession();
    	
    	ShoppingCart cart = (ShoppingCart) session.get("cart");
    	Users user = (Users) session.get("user");
    	if (user == null ) {
			return ERROR;
		}
    	Orders orders = new Orders();
    	orders.setCreateTime(new Timestamp(new Date().getTime()));
    	orders.setUsers(user);
    	int iNum = 0;
    	double jSum = 0;
    	for(Iterator iterator=cart.getDetailsMap().values().iterator();iterator.hasNext();){
    		OrdersDetails oDetails = (OrdersDetails) iterator.next();
    		iNum += oDetails.getNum();
    		jSum += oDetails.getNum() * oDetails.getPrice();
    		orders.getOrdersDetailses().add(oDetails);
    		oDetails.setOrders(orders);
    	}
    	orders.setSum(jSum);
    	orders.setNum(iNum);
    	order = flowerService.saveOrder(orders);
    	session.remove("cart");
    	
    	return SUCCESS;
    }


    public FlowerService getFlowerService() {
        return flowerService;
    }

    public void setFlowerService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Goods getFlower() {
        return flower;
    }

    public void setFlower(Goods flower) {
        this.flower = flower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
